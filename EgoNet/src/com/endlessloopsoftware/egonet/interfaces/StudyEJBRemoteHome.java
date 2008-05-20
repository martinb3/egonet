/*
 * Generated by XDoclet - Do not edit!
 */
package com.endlessloopsoftware.egonet.interfaces;

/**
 * Home interface for StudyEJB.
 */
public interface StudyEJBRemoteHome
   extends javax.ejb.EJBHome
{
   public static final String COMP_NAME="java:comp/env/ejb/StudyEJB";
   public static final String JNDI_NAME="StudyEJBHome";

   public com.endlessloopsoftware.egonet.interfaces.StudyEJBRemote create(com.endlessloopsoftware.egonet.util.StudyDataValue data)
      throws javax.ejb.CreateException,java.rmi.RemoteException;

   public com.endlessloopsoftware.egonet.interfaces.StudyEJBRemote findByPrimaryKey(com.endlessloopsoftware.egonet.interfaces.StudyEJBPK pk)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public java.util.Collection findAll()
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   public com.endlessloopsoftware.egonet.interfaces.StudyEJBRemote findByStudyName(java.lang.String name)
      throws javax.ejb.FinderException,java.rmi.RemoteException;

   /**
    * Returns Names of all Documents in Database
    */
   public java.util.Set getStudyNames()
      throws java.rmi.RemoteException;

}
