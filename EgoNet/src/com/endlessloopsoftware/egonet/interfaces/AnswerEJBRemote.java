/*
 * Generated by XDoclet - Do not edit!
 */
package com.endlessloopsoftware.egonet.interfaces;

/**
 * Remote interface for AnswerEJB.
 */
public interface AnswerEJBRemote
   extends javax.ejb.EJBObject
{

   public com.endlessloopsoftware.egonet.interfaces.QuestionEJBLocal getQuestion(  )
      throws java.rmi.RemoteException;

   public void setQuestion( com.endlessloopsoftware.egonet.interfaces.QuestionEJBLocal question )
      throws java.rmi.RemoteException;

   public com.endlessloopsoftware.egonet.interfaces.InterviewEJBLocal getInterview(  )
      throws java.rmi.RemoteException;

   public void setInterview( com.endlessloopsoftware.egonet.interfaces.InterviewEJBLocal interview )
      throws java.rmi.RemoteException;

}
