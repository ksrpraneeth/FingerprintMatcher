
if [ $# -eq 0 ]
  then
    echo "No arguments supplied"
else
java -Djava.library.path=/usr/local/lib  -cp :/home/ubuntu/TestFinger/mypack/lib/FDxSDKPro.jar:/home/ubuntu/TestFinger/mypack  FingerPrint $1 $2
fi

