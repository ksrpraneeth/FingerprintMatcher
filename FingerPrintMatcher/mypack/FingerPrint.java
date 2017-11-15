/*
 * JSGFPLibTest.java
 *
 * Created on February 4, 2005, 6:52 PM
 */


import java.io.*;
import SecuGen.FDxSDKPro.jni.*;
import java.util.Base64;
/**
 *
 * @author  Dan Riley
 */
public class FingerPrint{
    
    /** Creates a new instance of JFPLibTest */
    public FingerPrint() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        long err;


        byte[] SG400minutiaeBuffer1;
  
        byte[] ISOminutiaeBuffer1;
        byte[] SG400minutiaeBuffer2;
      
        byte[] ISOminutiaeBuffer2;
        FileOutputStream fout = null;
        PrintStream fp = null;
        
        ///////////////////////////////////////////////
        // Instantiate JSGFPLib object
        JSGFPLib sgfplib = new JSGFPLib();
        if ((sgfplib != null) && (sgfplib.jniLoadStatus != SGFDxErrorCode.SGFDX_ERROR_JNI_DLLLOAD_FAILED))
        { 
        }
        else
        {
            System.out.println("An error occurred while loading JSGFPLIB.DLL JNI Wrapper");
            return;
        }

        ///////////////////////////////////////////////
        // Init()
        err = sgfplib.Init(SGFDxDeviceName.SG_DEV_AUTO);
        ///////////////////////////////////////////////
        // GetLastError()
        err = sgfplib.GetLastError();
        boolean[] matched = new boolean[1];
        int[] score = new int[1];
        matched[0] = false;
        score[0] = 0;
        err = sgfplib.SetTemplateFormat(SGFDxTemplateFormat.TEMPLATE_FORMAT_ISO19794);
        String compare11 = args[0];
	String compare22 = args[1];
        ISOminutiaeBuffer1=  Base64.getDecoder().decode(compare11);
	ISOminutiaeBuffer2= Base64.getDecoder().decode(compare22);
        err = sgfplib.MatchIsoTemplate(ISOminutiaeBuffer1, 0, ISOminutiaeBuffer2, 0, SGFDxSecurityLevel.SL_NORMAL, matched);
        err = sgfplib.GetIsoMatchingScore(ISOminutiaeBuffer1, 0, ISOminutiaeBuffer2, 0, score);
        System.out.println(score[0]+"%%"+matched[0]);

        ///////////////////////////////////////////////
        // Close JSGFPLib native library
        sgfplib.Close();
        sgfplib = null;
        SG400minutiaeBuffer1 = null;
        ISOminutiaeBuffer1 = null;
        SG400minutiaeBuffer2 = null;
        ISOminutiaeBuffer2 = null;

    }    
}
