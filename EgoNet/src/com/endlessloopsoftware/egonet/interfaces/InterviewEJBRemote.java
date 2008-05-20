/*
 * Generated by XDoclet - Do not edit!
 */
package com.endlessloopsoftware.egonet.interfaces;

/**
 * Remote interface for InterviewEJB.
 */
public interface InterviewEJBRemote
   extends javax.ejb.EJBObject
{

   public java.lang.Long getId(  )
      throws java.rmi.RemoteException;

   public java.lang.String getFirstName(  )
      throws java.rmi.RemoteException;

   public java.lang.String getLastName(  )
      throws java.rmi.RemoteException;

   public java.lang.Boolean getComplete(  )
      throws java.rmi.RemoteException;

   public void setComplete( java.lang.Boolean i )
      throws java.rmi.RemoteException;

   public java.lang.String[] getAlters(  )
      throws java.rmi.RemoteException;

   public int[][] getAdjacencyMatrix(  )
      throws java.rmi.RemoteException;

   public void setAdjacencyMatrix( int[][] i )
      throws java.rmi.RemoteException;

   public com.endlessloopsoftware.egonet.interfaces.StudyEJBLocal getStudy(  )
      throws java.rmi.RemoteException;

   public void setStudy( com.endlessloopsoftware.egonet.interfaces.StudyEJBLocal study )
      throws java.rmi.RemoteException;

   public java.util.Set getAnswers(  )
      throws java.rmi.RemoteException;

   public void setAnswers( java.util.Set answers )
      throws java.rmi.RemoteException;

   public com.endlessloopsoftware.egonet.util.InterviewDataValue getInterviewDataValue(  )
      throws java.rmi.RemoteException;

   public void setInterviewDataValue( com.endlessloopsoftware.egonet.util.InterviewDataValue valueHolder )
      throws java.rmi.RemoteException;

}