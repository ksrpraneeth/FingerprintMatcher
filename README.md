# FingerprintMatcher
This project helps you to match two ISO/IEC 19794-2 fingerprint templates using secugen sdk in Linux. There is no need of fingerprint device to be connected for this to work.

# Prerequisites:

 - Pc running any flavour of Linux 
 -  Java JRE & SDK  
 -  Secugen Linux SDK

# Installing:

 - **Step 1**: Check whether your PC is 64 bit or 32 bit
             https://askubuntu.com/a/41334
 - **Step 2**: Install requied .So files from respected folder in this
   project to your pc's /usr/local/lib directory
                  
	 - *x86 : (32 bit)*
			Go to x86 folder and type "make"
	 - *x64 : (64 bit)*
			Go to x64 folder and type "make"
	  - These above instruction will install all the required drivers to /usr/local/lib
 - **Step 3**:
             Move "FingerPrintMatcher" folder to your "/home/<user>/" directory

 

 - **Step 4**:
             Move "runFingerPrintMatcher.sh"  to "/usr/local/bin/"
 - **Step 5**: Give execution permissions to "runFingerPrintMatcher.sh"

   

>  chmod u+x runFingerPrintMatcher.sh

 - **Step 6**: Open runFingerPrintMatcher.sh file and replace ***Java program path*** with your java program path

   

>  if [ $# -eq 0 ]
>       then
>         echo "No arguments supplied"
>     else
>     java -Djava.library.path=/usr/local/lib  -cp :/home/ubuntu/***Java program path***/mypack/lib/FDxSDKPro.jar:/***Java program path***/mypack  FingerPrint $1 $2
>     fi

 - **Step 7**: Run shell script by passing two ISO/IEC 19794-2 templates as
   arguments.
	- Template 1 :
	Rk1SACAyMAAAAAECAAABLAGQAMUAxQEAAABbJoCYACkBAEDJADN4AECkADqAAECMADsDAIB5AFUJAEDUAIXqAEC6AIZxAECqAJ/oAIB6AKIYAEDbAKfgAICJALEHAICaAMvXAICBAM0GAECxAM3ZAICCANisAIBpAN0sAECJAN/DAEBVAOOuAIA4AOOoAECFAOSzAICTAOfJAIBqAPQsAICbAQa5AID+AQdbAECkAQvGAECZARs1AICmARtvAIDmAR5eAEC1ASJuAIBRATspAEBcAUokAIDXAUtuAIB+AU0bAEDvAVdxAEDGAVz1AIBgAV0XAEC0AWf7AEDHAWp4AAAA
	 - Template 2:
	Rk1SACAyMAAAAAEaAAABLAGQAMUAxQEAAABWKoC8ABb/AECuACcAAEDHACh7AICZAD4GAIBYAG0kAEDWAHJxAEDwAHXoAICUAIgRAEDFAIvnAECkAJUAAED1AJbaAICxALTUAICYALYGAIDDALjZAICBAMIsAECaAMOsAIBQAMeoAECfAMfAAEBtAMisAECbAM2xAICpANHGAICAANosAIBFAOUpAICwAOu4AEC3APPGAIERAPtVAIC4AQXCAECsAQUzAID2AQ1bAEDHAQ5oAIBkASImAEBwATAiAIDNATJ5AICyATMLAICPATYYAIDmATtpAIBzAUUaAEDUAUrxAED9AUppAEDCAVT4AEDVAVlzAICiAXkEAAAA

**Command** :  
runFingerPrintMatcher.sh Rk1SACAyMAAAAAECAAABLAGQAMUAxQEAAABbJoCYACkBAEDJADN4AECkADqAAECMADsDAIB5AFUJAEDUAIXqAEC6AIZxAECqAJ/oAIB6AKIYAEDbAKfgAICJALEHAICaAMvXAICBAM0GAECxAM3ZAICCANisAIBpAN0sAECJAN/DAEBVAOOuAIA4AOOoAECFAOSzAICTAOfJAIBqAPQsAICbAQa5AID+AQdbAECkAQvGAECZARs1AICmARtvAIDmAR5eAEC1ASJuAIBRATspAEBcAUokAIDXAUtuAIB+AU0bAEDvAVdxAEDGAVz1AIBgAV0XAEC0AWf7AEDHAWp4AAAA Rk1SACAyMAAAAAEaAAABLAGQAMUAxQEAAABWKoC8ABb/AECuACcAAEDHACh7AICZAD4GAIBYAG0kAEDWAHJxAEDwAHXoAICUAIgRAEDFAIvnAECkAJUAAED1AJbaAICxALTUAICYALYGAIDDALjZAICBAMIsAECaAMOsAIBQAMeoAECfAMfAAEBtAMisAECbAM2xAICpANHGAICAANosAIBFAOUpAICwAOu4AEC3APPGAIERAPtVAIC4AQXCAECsAQUzAID2AQ1bAEDHAQ5oAIBkASImAEBwATAiAIDNATJ5AICyATMLAICPATYYAIDmATtpAIBzAUUaAEDUAUrxAED9AUppAEDCAVT4AEDVAVlzAICiAXkEAAAA

**Result** : 199%%true 

 - In above result '%%'  is the delimeter.   
- First part of the result will give you Score, The higher the score the better     the match is. 
- Second part of the reult will tell whether both templates provided
   are matching or not.

