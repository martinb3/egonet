/*
 * Generated by XDoclet - Do not edit!
 */
package com.endlessloopsoftware.egonet.data;

/**
 * CMP layer for StudyEJB.
 */
public abstract class StudyEJBCMP
   extends com.endlessloopsoftware.egonet.ejb.StudyEJB
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

/* Value Objects END */

   public abstract java.lang.Long getId() ;

   public abstract void setId( java.lang.Long id ) ;

   public abstract int getNumAlters() ;

   public abstract void setNumAlters( int numAlters ) ;

   public abstract java.lang.String getStudyName() ;

   public abstract void setStudyName( java.lang.String studyName ) ;

   public abstract java.lang.Long[][] getQuestionOrder() ;

   public abstract void setQuestionOrder( java.lang.Long[][] questionOrder ) ;

   public abstract java.lang.String getUIType() ;

   public abstract void setUIType( java.lang.String UIType ) ;

}
