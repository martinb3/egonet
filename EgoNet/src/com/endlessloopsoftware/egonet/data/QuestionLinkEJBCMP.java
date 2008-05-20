/*
 * Generated by XDoclet - Do not edit!
 */
package com.endlessloopsoftware.egonet.data;

/**
 * CMP layer for QuestionLinkEJB.
 */
public abstract class QuestionLinkEJBCMP
   extends com.endlessloopsoftware.egonet.ejb.QuestionLinkEJB
   implements javax.ejb.EntityBean
{

   public void ejbLoad() throws javax.ejb.EJBException
   {
      super.ejbLoad();
   }

   public void ejbStore() throws javax.ejb.EJBException
   {
         super.ejbStore();
   }

   public void ejbActivate() throws javax.ejb.EJBException
   {
      super.ejbActivate();
   }

   public void ejbPassivate() throws javax.ejb.EJBException
   {
      super.ejbPassivate();

      QuestionLinkDataValue = null;
   }

   public void setEntityContext(javax.ejb.EntityContext ctx) throws javax.ejb.EJBException
   {
      super.setEntityContext(ctx);
   }

   public void unsetEntityContext() throws javax.ejb.EJBException
   {
      super.unsetEntityContext();
   }

   public void ejbRemove() throws javax.ejb.EJBException, javax.ejb.RemoveException
   {
      super.ejbRemove();

   }

 /* Value Objects BEGIN */

   private com.endlessloopsoftware.egonet.data.QuestionLinkDataValue QuestionLinkDataValue = null;

   public com.endlessloopsoftware.egonet.data.QuestionLinkDataValue getQuestionLinkDataValue()
   {
      QuestionLinkDataValue = new com.endlessloopsoftware.egonet.data.QuestionLinkDataValue();
      try
         {
            QuestionLinkDataValue.setId( getId() );
            QuestionLinkDataValue.setQuestionId( getQuestionId() );
            QuestionLinkDataValue.setAnswerValue( getAnswerValue() );
            QuestionLinkDataValue.setAnswerString( getAnswerString() );
            QuestionLinkDataValue.setActive( getActive() );

         }
         catch (Exception e)
         {
            throw new javax.ejb.EJBException(e);
         }

	  return QuestionLinkDataValue;
   }

   public void setQuestionLinkDataValue( com.endlessloopsoftware.egonet.data.QuestionLinkDataValue valueHolder )
   {

	  try
	  {
		 setQuestionId( valueHolder.getQuestionId() );
		 setAnswerValue( valueHolder.getAnswerValue() );
		 setAnswerString( valueHolder.getAnswerString() );
		 setActive( valueHolder.getActive() );

	  }
	  catch (Exception e)
	  {
		 throw new javax.ejb.EJBException(e);
	  }
   }

/* Value Objects END */

   public abstract java.lang.String getId() ;

   public abstract void setId( java.lang.String id ) ;

   public abstract java.lang.Long getQuestionId() ;

   public abstract void setQuestionId( java.lang.Long questionId ) ;

   public abstract int getAnswerValue() ;

   public abstract void setAnswerValue( int answerValue ) ;

   public abstract java.lang.String getAnswerString() ;

   public abstract void setAnswerString( java.lang.String answerString ) ;

   public abstract boolean getActive() ;

   public abstract void setActive( boolean active ) ;

}