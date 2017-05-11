#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include "unistd.h"
#include <string.h>//字符串处理函数


#include <android/log.h>

#define LOG_TAG "System.out"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG,  __VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG,  __VA_ARGS__)


void showJavaDialog(JNIEnv *env, jobject obj, char * msg){
	//1.find class
		//jclass      (*FindClass)(JNIEnv*, const char*);
		jclass clazz = env->FindClass("com/example/chris/app0430/MainActivity");

		//2.get method id
		//jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
		jmethodID methodid = env->GetMethodID(clazz, "showDialog", "(Ljava/lang/String;)V");

		//3.call void  methoid
		//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
		env->CallVoidMethod(obj, methodid, env->NewStringUTF(msg));
}
void dismissJavaDialog(JNIEnv *env, jobject obj){
	//1.find class
		//jclass      (*FindClass)(JNIEnv*, const char*);
		jclass clazz = env->FindClass("com/example/chris/app0430/MainActivity");

		//2.get method id
		//jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
		jmethodID methodid = env->GetMethodID(clazz, "dismissDialog", "()V");

		//3.call void  methoid
		//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
		env->CallVoidMethod(obj, methodid);
}
extern "C"
/*
 * Class:     com_itheima_alipay_MainActivity
 * Method:    safePay
 * Signature: (Ljava/lang/String;Ljava/lang/String;F)I
 */
JNIEXPORT jint JNICALL Java_com_example_chris_app0430_MainActivity_safePay
  (JNIEnv *env, jobject obj, jstring jusername, jstring jpassword, jfloat jmoney){

	char *cusername = NULL;
	char *cpassword = NULL;

	jsize len = env->GetStringLength(jusername);
	cusername = (char *)malloc(len + 1);//'\0'
	//void        (*GetStringUTFRegion)(JNIEnv*, jstring, jsize, jsize, char*);
	env->GetStringUTFRegion(jusername, 0, len, cusername);

	len = env->GetStringLength(jpassword);
	cpassword = (char *)malloc(len + 1);//'\0'
	//void        (*GetStringUTFRegion)(JNIEnv*, jstring, jsize, jsize, char*);
	env->GetStringUTFRegion(jpassword, 0, len, cpassword);

//	LOGI("yong hu ming : %s",cusername);



//	LOGI("yong hu mi ma : %s",cpassword);

	//showJavaDialog(env,obj,"jia mi yong hu ming he mi ma");
	showJavaDialog(env,obj,"加密用户名和密码");
	sleep(2);

	showJavaDialog(env,obj,"jian cha zhi fu huan jing");
	sleep(2);

	showJavaDialog(env,obj,"lian jie ali fu wu qi ...");
	sleep(2);

	showJavaDialog(env,obj,"deng dai fan kui");
	sleep(2);

	dismissJavaDialog(env,obj);
	//用户名:abcd
	//密码： 1234
	//余额:2000

	//strcmp();实现字符串比较
	if(strcmp(cusername,"abcd") == 0 && strcmp(cpassword,"1234") == 0){
		if(jmoney < 2000){
			return 200;
		}else {
			return 403;
		}

	}else{
		return 404;
	}
}
