package org.egonet.model.question


import scala.collection.JavaConverters._

import org.scalatest.Args
import org.egonet.EgonetSpec
import org.egonet.exceptions.MalformedQuestionException
import org.egonet.model.v1.answer.Answer
import org.egonet.model.v1.answer.CategoricalAnswer
import org.egonet.model.v1.Shared;
import org.egonet.model.v1.question.Question;
import org.egonet.model.v1.question.Selection;
import org.egonet.model.v1.question.StudyQuestion;
import org.egonet.model.v1.question.EgoQuestion;
import org.egonet.model.v1.question.AlterQuestion;
import org.egonet.model.v1.question.AlterPromptQuestion;
import org.egonet.model.v1.question.AlterPairQuestion;

class QuestionTest extends EgonetSpec {

  "Question utility methods" should "correctly instantiate question types" in {
    
    intercept[MalformedQuestionException] {
       Question.asSubclass("please-dont-exist-as-a-class")
    }
    
    for(clazz <- Shared.questionClasses) {
    
      var clazzCanonicalName = clazz.getCanonicalName()
      
      assert(Question.newInstance(clazz).getClass().equals(clazz), 
          "Question.newInstance(" + clazzCanonicalName + ") should yield an instance of that type" )
    }
  }
    
    "Question getters and setters" should "set and get the same values" in {
      
      assert(new StudyQuestion().getTitle() == "Study questions")     
      assert(new EgoQuestion().getTitle() == "Questions About You")
      assert(new AlterQuestion().getTitle() == "<html><p>Questions About <nobr><b>$$1</b></nobr></p></html>")
      assert(new AlterPromptQuestion().getTitle() == "Whom do you know?")
      assert(new AlterPairQuestion().getTitle() == "<html><p>Questions About <nobr><b>$$1</b></nobr> and <nobr><b>$$2</b></nobr></p></html>")
      
      val q = new StudyQuestion("ignore")
    	List(true,false).foreach(t => { 
    	  q.setFollowupOnly(t)
    	  assert(q.isFollowupOnly == t)
    	})
    	
    	List(true,false).foreach(t => { 
    	  q.setStatable(t)
    	  assert(q.isStatable == t)
    	})
    	
    	val a = new CategoricalAnswer()
    	q.setAnswer(a)
    	assert(q.getAnswer() == a)
    	
    	val sAdjacent = new Selection()
      	sAdjacent.setAdjacent(true)
      	sAdjacent.setValue(12345)
      
    	val selections = List(
    	    new Selection(),
    	    sAdjacent, // determinesAdjacency=true
    	    new Selection()
    	    )
    	q.setSelections(selections.asJava)
    	
    	val rSelections = q.getSelections()
    	val zipped = selections.toArray.zipWithIndex
    	zipped.foreach({case (x,i) => {
    	  assert(x == rSelections.get(i))
    	}})
    	
    	assert(q.determinesAdjacency())
    	assert(q.selectionAdjacent(12345))
    	
    }
    
    
  
}