//
// Created by Stefanus Khrisna on 12/31/20.
//

#include <jni.h>
#include <string>
#include <iostream>


extern "C"
JNIEXPORT jdouble JNICALL
Java_id_ac_ui_cs_mobileprogramming_stefanus_1khrisna_nyepeda_ui_fragments_SettingsFragment_weightCalculation(
        JNIEnv *env, jobject thiz, jdouble number) {
    return number*2.205;
}