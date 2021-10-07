package com.android.fury.a30day.food;

import android.content.Context;

import com.android.fury.a30day.R;
import com.google.firebase.crash.FirebaseCrash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fury on 4/23/2017.
 */



public class list_food_cal {

    //string caleri ha
    public static String calery_1, calery_2, calery_3, calery_4, calery_5, calery_6, calery_7, calery_8, calery_9, calery_10, calery_11, calery_12, calery_13, calery_14, calery_15, calery_16, calery_17, calery_18, calery_19, calery_20, calery_21, calery_22, calery_23, calery_24, calery_25, calery_26, calery_27, calery_28, calery_29, calery_30, calery_31, calery_32, calery_33, calery_34, calery_35, calery_36, calery_37, calery_38, calery_39, calery_40, calery_41, calery_42, calery_43, calery_44, calery_45, calery_46, calery_47, calery_48, calery_49, calery_50, calery_51, calery_52, calery_53, calery_54, calery_55, calery_56, calery_57, calery_58, calery_59, calery_60, calery_61, calery_62, calery_63, calery_64, calery_65, calery_66, calery_67, calery_68, calery_69, calery_70, calery_71, calery_72, calery_73, calery_74, calery_75, calery_76, calery_77, calery_78, calery_79, calery_80, calery_81, calery_82, calery_83, calery_84, calery_85, calery_86, calery_87, calery_88, calery_89, calery_90, calery_91, calery_92, calery_93, calery_94, calery_95, calery_96, calery_97, calery_98, calery_99, calery_100, calery_101, calery_102, calery_103, calery_104, calery_105, calery_106, calery_107, calery_108, calery_109, calery_110, calery_111, calery_112, calery_113, calery_114, calery_115, calery_116, calery_117, calery_118, calery_119, calery_120, calery_121, calery_122, calery_123, calery_124, calery_125, calery_126, calery_127, calery_128, calery_129, calery_130, calery_131, calery_132, calery_133, calery_134, calery_135, calery_136, calery_137, calery_138, calery_139, calery_140, calery_141, calery_142, calery_143, calery_144, calery_145, calery_146, calery_147, calery_148, calery_149, calery_150, calery_151, calery_152, calery_153, calery_154, calery_155, calery_156, calery_157, calery_158, calery_159, calery_160, calery_161, calery_162, calery_163, calery_164, calery_165, calery_166, calery_167, calery_168, calery_169, calery_170, calery_171, calery_172, calery_173, calery_174, calery_175, calery_176, calery_177, calery_178, calery_179, calery_180, calery_181, calery_182, calery_183, calery_184, calery_185, calery_186, calery_187, calery_188, calery_189, calery_190, calery_191, calery_192, calery_193, calery_194, calery_195, calery_196, calery_197, calery_198, calery_199, calery_200, calery_201, calery_202, calery_203, calery_204, calery_205, calery_206, calery_207, calery_208, calery_209, calery_210, calery_211, calery_212, calery_213, calery_214, calery_215, calery_216, calery_217, calery_218, calery_219, calery_220, calery_221, calery_222, calery_223, calery_224, calery_225, calery_226, calery_227, calery_228, calery_229, calery_230, calery_231, calery_232, calery_233, calery_234, calery_235, calery_236, calery_237, calery_238, calery_239, calery_240, calery_241, calery_242, calery_243, calery_244, calery_245, calery_246, calery_247, calery_248, calery_249, calery_250, calery_251, calery_252, calery_253, calery_254, calery_255, calery_256, calery_257, calery_258, calery_259, calery_260, calery_261, calery_262, calery_263, calery_264, calery_265, calery_266, calery_267, calery_268, calery_269, calery_270, calery_271, calery_272, calery_273, calery_274, calery_275, calery_276, calery_277, calery_278, calery_279, calery_280, calery_281, calery_282, calery_283;


    //string food ha
    public static String food_1, food_2, food_3, food_4, food_5, food_6, food_7, food_8, food_9, food_10, food_11, food_12, food_13, food_14, food_15, food_16, food_17, food_18, food_19, food_20, food_21, food_22, food_23, food_24, food_25, food_26, food_27, food_28, food_29, food_30, food_31, food_32, food_33, food_34, food_35, food_36, food_37, food_38, food_39, food_40, food_41, food_42, food_43, food_44, food_45, food_46, food_47, food_48, food_49, food_50, food_51, food_52, food_53, food_54, food_55, food_56, food_57, food_58, food_59, food_60, food_61, food_62, food_63, food_64, food_65, food_66, food_67, food_68, food_69, food_70, food_71, food_72, food_73, food_74, food_75, food_76, food_77, food_78, food_79, food_80, food_81, food_82, food_83, food_84, food_85, food_86, food_87, food_88, food_89, food_90, food_91, food_92, food_93, food_94, food_95, food_96, food_97, food_98, food_99, food_100, food_101, food_102, food_103, food_104, food_105, food_106, food_107, food_108, food_109, food_110, food_111, food_112, food_114, food_115, food_116, food_117, food_118, food_119, food_120, food_121, food_122, food_123, food_124, food_125, food_126, food_128, food_129, food_130, food_131, food_132, food_133, food_134, food_135, food_136, food_137, food_138, food_139, food_140, food_141, food_142, food_143, food_144, food_145, food_146, food_147, food_148, food_149, food_150, food_151, food_152, food_153, food_154, food_155, food_156, food_157, food_158, food_159, food_160, food_161, food_162, food_163, food_164, food_165, food_166, food_167, food_168, food_171, food_172, food_173, food_174, food_175, food_176, food_177, food_178, food_179, food_180, food_181, food_182, food_183, food_184, food_185, food_186, food_187, food_188, food_189, food_190, food_191, food_192, food_193, food_194, food_195, food_196, food_197, food_198, food_199, food_200, food_201, food_202, food_203, food_204, food_205, food_206, food_207, food_208, food_209, food_210, food_212, food_213, food_214, food_215, food_216, food_217, food_218, food_219, food_220, food_221, food_222, food_223, food_224, food_225, food_226, food_227, food_228, food_229, food_230, food_231, food_232, food_233, food_234, food_235, food_236, food_237, food_238, food_240, food_241, food_242, food_243, food_244, food_245, food_246, food_247, food_248, food_249, food_250, food_251, food_252, food_253, food_254, food_255, food_256, food_257, food_258, food_259, food_260, food_261, food_262, food_263, food_264, food_265, food_266, food_267, food_268, food_269, food_270, food_271, food_272, food_273, food_274, food_275, food_276, food_277, food_278, food_279, food_280, food_281, food_282, food_283, food_169;


    //string size ha
    public static String size_1, size_2, size_3, size_4, size_5, size_6, size_7, size_8, size_9, size_10, size_11, size_12, size_13, size_14, size_15, size_16, size_17, size_18, size_19, size_20, size_21, size_22, size_23, size_24, size_25, size_26, size_27, size_28, size_29, size_30, size_31, size_32, size_33, size_34, size_35, size_36, size_37, size_38, size_39, size_40, size_41, size_42, size_43, size_44, size_45, size_46, size_47, size_48, size_49, size_50, size_51, size_52, size_53, size_54, size_55, size_56, size_57, size_58, size_59, size_60, size_61, size_62, size_63, size_64, size_65, size_66, size_67, size_68, size_69, size_70, size_71, size_72, size_73, size_74, size_75, size_76, size_77, size_78, size_79, size_80, size_81, size_82, size_83, size_84, size_85, size_86, size_87, size_88, size_89, size_90, size_91, size_92, size_93, size_94, size_95, size_96, size_97, size_98, size_99, size_100, size_101, size_102, size_103, size_104, size_105, size_106, size_107, size_108, size_109, size_110, size_111, size_112, size_113, size_114, size_115, size_116, size_117, size_118, size_119, size_120, size_121, size_122, size_123, size_124, size_125, size_126, size_127, size_128, size_129, size_130, size_131, size_132, size_133, size_134, size_135, size_136, size_137, size_138, size_139, size_140, size_141, size_142, size_143, size_144, size_145, size_146, size_147, size_148, size_149, size_150, size_151, size_152, size_153, size_154, size_155, size_156, size_157, size_158, size_159, size_160, size_161, size_162, size_163, size_164, size_165, size_166, size_167, size_168, size_169, size_170, size_171, size_172, size_173, size_174, size_175, size_176, size_177, size_178, size_179, size_180, size_181, size_182, size_183, size_184, size_185, size_186, size_187, size_188, size_189, size_190, size_191, size_192, size_193, size_194, size_195, size_196, size_197, size_198, size_199, size_200, size_201, size_202, size_203, size_204, size_205, size_206, size_207, size_208, size_209, size_210, size_211, size_212, size_213, size_214, size_215, size_216, size_217, size_218, size_219, size_220, size_221, size_222, size_223, size_224, size_225, size_226, size_227, size_228, size_229, size_230, size_231, size_232, size_233, size_234, size_235, size_236, size_237, size_238, size_239, size_240, size_241, size_242, size_243, size_244, size_245, size_246, size_247, size_248, size_249, size_250, size_251, size_252, size_253, size_254, size_255, size_256, size_257, size_258, size_259, size_260, size_261, size_262, size_263, size_264, size_265, size_266, size_267, size_268, size_269, size_270, size_271, size_272, size_273, size_274, size_275, size_276, size_277, size_278, size_279, size_280, size_281, size_282, size_283;
    public static HashMap<String, String> temp, temp2, temp3, temp4, temp5, temp6, temp7, temp8, temp9, temp10, temp11, temp12, temp13, temp14, temp15, temp16, temp17, temp18, temp19, temp20, temp21, temp22, temp23, temp24, temp25, temp26, temp27, temp28, temp29, temp30, temp31, temp32, temp33, temp34, temp35, temp36, temp37, temp38, temp39, temp40, temp41, temp42, temp43, temp44, temp45, temp46, temp47, temp48, temp49, temp50, temp51, temp52, temp53, temp54, temp55, temp56, temp57, temp58, temp59, temp60, temp61, temp62, temp63, temp64, temp65, temp66, temp67, temp68, temp69, temp70, temp71, temp72, temp73, temp74, temp75, temp76, temp77, temp78, temp79, temp80, temp81, temp82, temp83, temp84, temp85, temp86, temp87, temp88, temp89, temp90, temp91, temp92, temp93, temp94, temp95, temp96, temp97, temp98, temp99, temp100, temp101, temp102, temp103, temp104, temp105, temp106, temp107, temp108, temp109, temp110, temp111, temp112, temp113, temp114, temp115, temp116, temp117, temp118, temp119, temp120, temp121, temp122, temp123, temp124, temp125, temp126, temp127, temp128, temp129, temp130, temp131, temp132, temp133, temp134, temp135, temp136, temp137, temp138, temp139, temp140, temp141, temp142, temp143, temp144, temp145, temp146, temp147, temp148, temp149, temp150, temp151, temp152, temp153, temp154, temp155, temp156, temp157, temp158, temp159, temp160, temp161, temp162, temp163, temp164, temp165, temp166, temp167, temp168, temp169, temp170, temp171, temp172, temp173, temp174, temp175, temp176, temp177, temp178, temp179, temp180, temp181, temp182, temp183, temp184, temp185, temp186, temp187, temp188, temp189, temp190, temp191, temp192, temp193, temp194, temp195, temp196, temp197, temp198, temp199, temp200, temp201, temp202, temp203, temp204, temp205, temp206, temp207, temp208, temp209, temp210, temp211, temp212, temp213, temp214, temp215, temp216, temp217, temp218, temp219, temp220, temp221, temp222, temp223, temp224, temp225, temp226, temp227, temp228, temp229, temp230, temp231, temp232, temp233, temp234, temp235, temp236, temp237, temp238, temp239, temp240, temp241, temp242, temp243, temp244, temp245, temp246, temp247, temp248, temp249, temp250, temp251, temp252, temp253, temp254, temp255, temp256, temp257, temp258, temp259, temp260, temp261, temp262, temp263, temp264, temp265, temp266, temp267, temp268, temp269, temp270, temp271, temp272, temp273, temp274, temp275, temp276, temp277, temp278, temp279, temp280, temp281, temp282, temp283;

    public static String FIRST_COLUMN;
    public static String SECOND_COLUMN;
    public static String SECOND_COLUMN_2;

    public static ArrayList<HashMap<String, String>> list;
    public static ArrayList<HashMap<String, String>> list_c;
    public static ArrayList<HashMap<String, String>> list_b;

    static Context x;

    public static list_food_cal getInstance(Context ctx) {
        x = ctx;
        return null;
    }

    public static void populateList() {


        food_1 = (String) x.getText(R.string.food_Calorie_food_1);
        food_2 = (String) x.getText(R.string.food_Calorie_food_178);
        food_3 = (String) x.getText(R.string.food_Calorie_food_179);
        food_4 = (String) x.getText(R.string.food_Calorie_food_180);
        food_5 = (String) x.getText(R.string.food_Calorie_food_181);
        food_6 = (String) x.getText(R.string.food_Calorie_food_182);
        food_7 = (String) x.getText(R.string.food_Calorie_food_183);
        food_8 = (String) x.getText(R.string.food_Calorie_food_184);
        food_9 = (String) x.getText(R.string.food_Calorie_food_185);
        food_10 = (String) x.getText(R.string.food_Calorie_food_186);
        food_11 = (String) x.getText(R.string.food_Calorie_food_187);
        food_12 = (String) x.getText(R.string.food_Calorie_food_188);
        food_13 = (String) x.getText(R.string.food_Calorie_food_189);
        food_14 = (String) x.getText(R.string.food_Calorie_food_190);
        food_15 = (String) x.getText(R.string.food_Calorie_food_191);
        food_16 = (String) x.getText(R.string.food_Calorie_food_192);
        food_17 = (String) x.getText(R.string.food_Calorie_food_193);
        food_18 = (String) x.getText(R.string.food_Calorie_food_194);
        food_19 = (String) x.getText(R.string.food_Calorie_food_195);
        food_20 = (String) x.getText(R.string.food_Calorie_food_196);
        food_21 = (String) x.getText(R.string.food_Calorie_food_197);
        food_22 = (String) x.getText(R.string.food_Calorie_food_198);
        food_23 = (String) x.getText(R.string.food_Calorie_food_199);
        food_24 = (String) x.getText(R.string.food_Calorie_food_200);
        food_25 = (String) x.getText(R.string.food_Calorie_food_201);
        food_26 = (String) x.getText(R.string.food_Calorie_food_202);
        food_27 = (String) x.getText(R.string.food_Calorie_food_203);
        food_28 = (String) x.getText(R.string.food_Calorie_food_204);
        food_29 = (String) x.getText(R.string.food_Calorie_food_205);
        food_30 = (String) x.getText(R.string.food_Calorie_food_206);
        food_31 = (String) x.getText(R.string.food_Calorie_food_207);
        food_32 = (String) x.getText(R.string.food_Calorie_food_208);
        food_33 = (String) x.getText(R.string.food_Calorie_food_209);
        food_34 = (String) x.getText(R.string.food_Calorie_food_210);
        food_35 = (String) x.getText(R.string.food_Calorie_food_211);
        food_36 = (String) x.getText(R.string.food_Calorie_food_212);
        food_37 = (String) x.getText(R.string.food_Calorie_food_213);
        food_38 = (String) x.getText(R.string.food_Calorie_food_214);
        food_39 = (String) x.getText(R.string.food_Calorie_food_215);
        food_40 = (String) x.getText(R.string.food_Calorie_food_216);
        food_41 = (String) x.getText(R.string.food_Calorie_food_217);
        food_42 = (String) x.getText(R.string.food_Calorie_food_218);
        food_43 = (String) x.getText(R.string.food_Calorie_food_219);
        food_44 = (String) x.getText(R.string.food_Calorie_food_220);
        food_45 = (String) x.getText(R.string.food_Calorie_food_221);
        food_46 = (String) x.getText(R.string.food_Calorie_food_222);
        food_47 = (String) x.getText(R.string.food_Calorie_food_223);
        food_48 = (String) x.getText(R.string.food_Calorie_food_224);
        food_49 = (String) x.getText(R.string.food_Calorie_food_225);
        food_50 = (String) x.getText(R.string.food_Calorie_food_226);
        food_51 = (String) x.getText(R.string.food_Calorie_food_227);
        food_52 = (String) x.getText(R.string.food_Calorie_food_228);
        food_53 = (String) x.getText(R.string.food_Calorie_food_229);
        food_54 = (String) x.getText(R.string.food_Calorie_food_230);
        food_55 = (String) x.getText(R.string.food_Calorie_food_231);
        food_56 = (String) x.getText(R.string.food_Calorie_food_232);
        food_57 = (String) x.getText(R.string.food_Calorie_food_233);
        food_58 = (String) x.getText(R.string.food_Calorie_food_234);
        food_59 = (String) x.getText(R.string.food_Calorie_food_235);
        food_60 = (String) x.getText(R.string.food_Calorie_food_236);
        food_61 = (String) x.getText(R.string.food_Calorie_food_237);
        food_62 = (String) x.getText(R.string.food_Calorie_food_238);
        food_63 = (String) x.getText(R.string.food_Calorie_food_239);
        food_64 = (String) x.getText(R.string.food_Calorie_food_240);
        food_65 = (String) x.getText(R.string.food_Calorie_food_241);
        food_66 = (String) x.getText(R.string.food_Calorie_food_242);
        food_67 = (String) x.getText(R.string.food_Calorie_food_243);
        food_68 = (String) x.getText(R.string.food_Calorie_food_244);
        food_69 = (String) x.getText(R.string.food_Calorie_food_245);
        food_70 = (String) x.getText(R.string.food_Calorie_food_246);
        food_71 = (String) x.getText(R.string.food_Calorie_food_247);
        food_72 = (String) x.getText(R.string.food_Calorie_food_248);
        food_73 = (String) x.getText(R.string.food_Calorie_food_249);
        food_74 = (String) x.getText(R.string.food_Calorie_food_250);
        food_75 = (String) x.getText(R.string.food_Calorie_food_251);
        food_76 = (String) x.getText(R.string.food_Calorie_food_252);
        food_77 = (String) x.getText(R.string.food_Calorie_food_253);
        food_78 = (String) x.getText(R.string.food_Calorie_food_254);
        food_79 = (String) x.getText(R.string.food_Calorie_food_255);
        food_80 = (String) x.getText(R.string.food_Calorie_food_256);
        food_81 = (String) x.getText(R.string.food_Calorie_food_257);
        food_82 = (String) x.getText(R.string.food_Calorie_food_258);
        food_83 = (String) x.getText(R.string.food_Calorie_food_259);
        food_84 = (String) x.getText(R.string.food_Calorie_food_260);
        food_85 = (String) x.getText(R.string.food_Calorie_food_261);
        food_86 = (String) x.getText(R.string.food_Calorie_food_262);
        food_87 = (String) x.getText(R.string.food_Calorie_food_263);
        food_88 = (String) x.getText(R.string.food_Calorie_food_264);
        food_89 = (String) x.getText(R.string.food_Calorie_food_265);
        food_90 = (String) x.getText(R.string.food_Calorie_food_266);
        food_91 = (String) x.getText(R.string.food_Calorie_food_267);
        food_92 = (String) x.getText(R.string.food_Calorie_food_268);
        food_93 = (String) x.getText(R.string.food_Calorie_food_269);
        food_94 = (String) x.getText(R.string.food_Calorie_food_270);
        food_95 = (String) x.getText(R.string.food_Calorie_food_271);
        food_96 = (String) x.getText(R.string.food_Calorie_food_272);
        food_97 = (String) x.getText(R.string.food_Calorie_food_273);
        food_98 = (String) x.getText(R.string.food_Calorie_food_274);
        food_99 = (String) x.getText(R.string.food_Calorie_food_275);
        food_100 = (String) x.getText(R.string.food_Calorie_food_276);
        food_101 = (String) x.getText(R.string.food_Calorie_food_277);
        food_102 = (String) x.getText(R.string.food_Calorie_food_278);
        food_103 = (String) x.getText(R.string.food_Calorie_food_279);
        food_104 = (String) x.getText(R.string.food_Calorie_food_280);
        food_105 = (String) x.getText(R.string.food_Calorie_food_281);
        food_106 = (String) x.getText(R.string.food_Calorie_food_282);
        food_107 = (String) x.getText(R.string.food_Calorie_food_283);
        food_108 = (String) x.getText(R.string.food_Calorie_food_284);
        food_109 = (String) x.getText(R.string.food_Calorie_food_285);
        food_110 = (String) x.getText(R.string.food_Calorie_food_286);
        food_111 = (String) x.getText(R.string.food_Calorie_food_2);
        food_112 = (String) x.getText(R.string.food_Calorie_food_3);
        food_114 = (String) x.getText(R.string.food_Calorie_food_5);
        food_115 = (String) x.getText(R.string.food_Calorie_food_6);
        food_116 = (String) x.getText(R.string.food_Calorie_food_7);
        food_117 = (String) x.getText(R.string.food_Calorie_food_8);
        food_118 = (String) x.getText(R.string.food_Calorie_food_9);
        food_119 = (String) x.getText(R.string.food_Calorie_food_10);
        food_120 = (String) x.getText(R.string.food_Calorie_food_12);
        food_121 = (String) x.getText(R.string.food_Calorie_food_13);
        food_122 = (String) x.getText(R.string.food_Calorie_food_14);
        food_123 = (String) x.getText(R.string.food_Calorie_food_15);
        food_124 = (String) x.getText(R.string.food_Calorie_food_16);
        food_125 = (String) x.getText(R.string.food_Calorie_food_17);
        food_126 = (String) x.getText(R.string.food_Calorie_food_18);
        food_128 = (String) x.getText(R.string.food_Calorie_food_21);
        food_129 = (String) x.getText(R.string.food_Calorie_food_22);
        food_130 = (String) x.getText(R.string.food_Calorie_food_23);
        food_131 = (String) x.getText(R.string.food_Calorie_food_24);
        food_132 = (String) x.getText(R.string.food_Calorie_food_25);
        food_133 = (String) x.getText(R.string.food_Calorie_food_26);
        food_134 = (String) x.getText(R.string.food_Calorie_food_27);
        food_135 = (String) x.getText(R.string.food_Calorie_food_28);
        food_136 = (String) x.getText(R.string.food_Calorie_food_29);
        food_137 = (String) x.getText(R.string.food_Calorie_food_30);
        food_138 = (String) x.getText(R.string.food_Calorie_food_31);
        food_139 = (String) x.getText(R.string.food_Calorie_food_32);
        food_140 = (String) x.getText(R.string.food_Calorie_food_33);
        food_141 = (String) x.getText(R.string.food_Calorie_food_34);
        food_142 = (String) x.getText(R.string.food_Calorie_food_35);
        food_143 = (String) x.getText(R.string.food_Calorie_food_36);
        food_144 = (String) x.getText(R.string.food_Calorie_food_37);
        food_145 = (String) x.getText(R.string.food_Calorie_food_38);
        food_146 = (String) x.getText(R.string.food_Calorie_food_39);
        food_147 = (String) x.getText(R.string.food_Calorie_food_40);
        food_148 = (String) x.getText(R.string.food_Calorie_food_41);
        food_149 = (String) x.getText(R.string.food_Calorie_food_42);
        food_150 = (String) x.getText(R.string.food_Calorie_food_43);
        food_151 = (String) x.getText(R.string.food_Calorie_food_44);
        food_152 = (String) x.getText(R.string.food_Calorie_food_45);
        food_153 = (String) x.getText(R.string.food_Calorie_food_46);
        food_154 = (String) x.getText(R.string.food_Calorie_food_47);
        food_155 = (String) x.getText(R.string.food_Calorie_food_48);
        food_156 = (String) x.getText(R.string.food_Calorie_food_49);
        food_157 = (String) x.getText(R.string.food_Calorie_food_50);
        food_158 = (String) x.getText(R.string.food_Calorie_food_51);
        food_159 = (String) x.getText(R.string.food_Calorie_food_52);
        food_160 = (String) x.getText(R.string.food_Calorie_food_53);
        food_161 = (String) x.getText(R.string.food_Calorie_food_54);
        food_162 = (String) x.getText(R.string.food_Calorie_food_55);
        food_163 = (String) x.getText(R.string.food_Calorie_food_56);
        food_164 = (String) x.getText(R.string.food_Calorie_food_57);
        food_165 = (String) x.getText(R.string.food_Calorie_food_58);
        food_166 = (String) x.getText(R.string.food_Calorie_food_59);
        food_167 = (String) x.getText(R.string.food_Calorie_food_60);
        food_168 = (String) x.getText(R.string.food_Calorie_food_61);
        food_169 = (String) x.getText(R.string.food_Calorie_food_62);
        food_171 = (String) x.getText(R.string.food_Calorie_food_64);
        food_172 = (String) x.getText(R.string.food_Calorie_food_65);
        food_173 = (String) x.getText(R.string.food_Calorie_food_66);
        food_174 = (String) x.getText(R.string.food_Calorie_food_67);
        food_175 = (String) x.getText(R.string.food_Calorie_food_68);
        food_176 = (String) x.getText(R.string.food_Calorie_food_69);
        food_177 = (String) x.getText(R.string.food_Calorie_food_70);
        food_178 = (String) x.getText(R.string.food_Calorie_food_71);
        food_179 = (String) x.getText(R.string.food_Calorie_food_72);
        food_180 = (String) x.getText(R.string.food_Calorie_food_73);
        food_181 = (String) x.getText(R.string.food_Calorie_food_74);
        food_182 = (String) x.getText(R.string.food_Calorie_food_75);
        food_183 = (String) x.getText(R.string.food_Calorie_food_76);
        food_184 = (String) x.getText(R.string.food_Calorie_food_77);
        food_185 = (String) x.getText(R.string.food_Calorie_food_78);
        food_186 = (String) x.getText(R.string.food_Calorie_food_79);
        food_187 = (String) x.getText(R.string.food_Calorie_food_80);
        food_188 = (String) x.getText(R.string.food_Calorie_food_81);
        food_189 = (String) x.getText(R.string.food_Calorie_food_82);
        food_190 = (String) x.getText(R.string.food_Calorie_food_83);
        food_191 = (String) x.getText(R.string.food_Calorie_food_84);
        food_192 = (String) x.getText(R.string.food_Calorie_food_85);
        food_193 = (String) x.getText(R.string.food_Calorie_food_86);
        food_194 = (String) x.getText(R.string.food_Calorie_food_87);
        food_195 = (String) x.getText(R.string.food_Calorie_food_88);
        food_196 = (String) x.getText(R.string.food_Calorie_food_89);
        food_197 = (String) x.getText(R.string.food_Calorie_food_90);
        food_198 = (String) x.getText(R.string.food_Calorie_food_91);
        food_199 = (String) x.getText(R.string.food_Calorie_food_92);
        food_200 = (String) x.getText(R.string.food_Calorie_food_93);
        food_201 = (String) x.getText(R.string.food_Calorie_food_94);
        food_202 = (String) x.getText(R.string.food_Calorie_food_95);
        food_203 = (String) x.getText(R.string.food_Calorie_food_96);
        food_204 = (String) x.getText(R.string.food_Calorie_food_97);
        food_205 = (String) x.getText(R.string.food_Calorie_food_98);
        food_206 = (String) x.getText(R.string.food_Calorie_food_99);
        food_207 = (String) x.getText(R.string.food_Calorie_food_100);
        food_208 = (String) x.getText(R.string.food_Calorie_food_101);
        food_209 = (String) x.getText(R.string.food_Calorie_food_102);
        food_210 = (String) x.getText(R.string.food_Calorie_food_103);
        food_212 = (String) x.getText(R.string.food_Calorie_food_105);
        food_213 = (String) x.getText(R.string.food_Calorie_food_106);
        food_214 = (String) x.getText(R.string.food_Calorie_food_107);
        food_215 = (String) x.getText(R.string.food_Calorie_food_108);
        food_216 = (String) x.getText(R.string.food_Calorie_food_109);
        food_217 = (String) x.getText(R.string.food_Calorie_food_110);
        food_218 = (String) x.getText(R.string.food_Calorie_food_111);
        food_219 = (String) x.getText(R.string.food_Calorie_food_112);
        food_220 = (String) x.getText(R.string.food_Calorie_food_113);
        food_221 = (String) x.getText(R.string.food_Calorie_food_114);
        food_222 = (String) x.getText(R.string.food_Calorie_food_115);
        food_223 = (String) x.getText(R.string.food_Calorie_food_116);
        food_224 = (String) x.getText(R.string.food_Calorie_food_117);
        food_225 = (String) x.getText(R.string.food_Calorie_food_118);
        food_226 = (String) x.getText(R.string.food_Calorie_food_119);
        food_227 = (String) x.getText(R.string.food_Calorie_food_120);
        food_228 = (String) x.getText(R.string.food_Calorie_food_121);
        food_229 = (String) x.getText(R.string.food_Calorie_food_122);
        food_230 = (String) x.getText(R.string.food_Calorie_food_123);
        food_231 = (String) x.getText(R.string.food_Calorie_food_124);
        food_232 = (String) x.getText(R.string.food_Calorie_food_125);
        food_233 = (String) x.getText(R.string.food_Calorie_food_126);
        food_234 = (String) x.getText(R.string.food_Calorie_food_127);
        food_235 = (String) x.getText(R.string.food_Calorie_food_129);
        food_236 = (String) x.getText(R.string.food_Calorie_food_130);
        food_237 = (String) x.getText(R.string.food_Calorie_food_131);
        food_238 = (String) x.getText(R.string.food_Calorie_food_132);
        food_240 = (String) x.getText(R.string.food_Calorie_food_134);
        food_241 = (String) x.getText(R.string.food_Calorie_food_135);
        food_242 = (String) x.getText(R.string.food_Calorie_food_136);
        food_243 = (String) x.getText(R.string.food_Calorie_food_137);
        food_244 = (String) x.getText(R.string.food_Calorie_food_138);
        food_245 = (String) x.getText(R.string.food_Calorie_food_139);
        food_246 = (String) x.getText(R.string.food_Calorie_food_140);
        food_247 = (String) x.getText(R.string.food_Calorie_food_141);
        food_248 = (String) x.getText(R.string.food_Calorie_food_142);
        food_249 = (String) x.getText(R.string.food_Calorie_food_143);
        food_250 = (String) x.getText(R.string.food_Calorie_food_144);
        food_251 = (String) x.getText(R.string.food_Calorie_food_145);
        food_252 = (String) x.getText(R.string.food_Calorie_food_146);
        food_253 = (String) x.getText(R.string.food_Calorie_food_147);
        food_254 = (String) x.getText(R.string.food_Calorie_food_148);
        food_255 = (String) x.getText(R.string.food_Calorie_food_149);
        food_256 = (String) x.getText(R.string.food_Calorie_food_150);
        food_257 = (String) x.getText(R.string.food_Calorie_food_151);
        food_258 = (String) x.getText(R.string.food_Calorie_food_152);
        food_259 = (String) x.getText(R.string.food_Calorie_food_153);
        food_260 = (String) x.getText(R.string.food_Calorie_food_154);
        food_261 = (String) x.getText(R.string.food_Calorie_food_155);
        food_262 = (String) x.getText(R.string.food_Calorie_food_156);
        food_263 = (String) x.getText(R.string.food_Calorie_food_157);
        food_264 = (String) x.getText(R.string.food_Calorie_food_158);
        food_265 = (String) x.getText(R.string.food_Calorie_food_159);
        food_266 = (String) x.getText(R.string.food_Calorie_food_160);
        food_267 = (String) x.getText(R.string.food_Calorie_food_161);
        food_268 = (String) x.getText(R.string.food_Calorie_food_162);
        food_269 = (String) x.getText(R.string.food_Calorie_food_163);
        food_270 = (String) x.getText(R.string.food_Calorie_food_164);
        food_271 = (String) x.getText(R.string.food_Calorie_food_165);
        food_272 = (String) x.getText(R.string.food_Calorie_food_166);
        food_273 = (String) x.getText(R.string.food_Calorie_food_167);
        food_274 = (String) x.getText(R.string.food_Calorie_food_168);
        food_275 = (String) x.getText(R.string.food_Calorie_food_169);
        food_276 = (String) x.getText(R.string.food_Calorie_food_170);
        food_277 = (String) x.getText(R.string.food_Calorie_food_171);
        food_278 = (String) x.getText(R.string.food_Calorie_food_172);
        food_279 = (String) x.getText(R.string.food_Calorie_food_173);
        food_280 = (String) x.getText(R.string.food_Calorie_food_174);
        food_281 = (String) x.getText(R.string.food_Calorie_food_175);
        food_282 = (String) x.getText(R.string.food_Calorie_food_176);
        food_283 = (String) x.getText(R.string.food_Calorie_food_177);


        // id size ha


        size_1 = (String) x.getText(R.string.food_Calorie_food_size_1);
        size_2 = (String) x.getText(R.string.food_Calorie_food_size_178);
        size_3 = (String) x.getText(R.string.food_Calorie_food_size_179);
        size_4 = (String) x.getText(R.string.food_Calorie_food_size_180);
        size_5 = (String) x.getText(R.string.food_Calorie_food_size_181);
        size_6 = (String) x.getText(R.string.food_Calorie_food_size_182);
        size_7 = (String) x.getText(R.string.food_Calorie_food_size_183);
        size_8 = (String) x.getText(R.string.food_Calorie_food_size_184);
        size_9 = (String) x.getText(R.string.food_Calorie_food_size_185);
        size_10 = (String) x.getText(R.string.food_Calorie_food_size_186);
        size_11 = (String) x.getText(R.string.food_Calorie_food_size_187);
        size_12 = (String) x.getText(R.string.food_Calorie_food_size_188);
        size_13 = (String) x.getText(R.string.food_Calorie_food_size_189);
        size_14 = (String) x.getText(R.string.food_Calorie_food_size_190);
        size_15 = (String) x.getText(R.string.food_Calorie_food_size_191);
        size_16 = (String) x.getText(R.string.food_Calorie_food_size_192);
        size_17 = (String) x.getText(R.string.food_Calorie_food_size_193);
        size_18 = (String) x.getText(R.string.food_Calorie_food_size_194);
        size_19 = (String) x.getText(R.string.food_Calorie_food_size_195);
        size_20 = (String) x.getText(R.string.food_Calorie_food_size_196);
        size_21 = (String) x.getText(R.string.food_Calorie_food_size_197);
        size_22 = (String) x.getText(R.string.food_Calorie_food_size_198);
        size_23 = (String) x.getText(R.string.food_Calorie_food_size_199);
        size_24 = (String) x.getText(R.string.food_Calorie_food_size_200);
        size_25 = (String) x.getText(R.string.food_Calorie_food_size_201);
        size_26 = (String) x.getText(R.string.food_Calorie_food_size_202);
        size_27 = (String) x.getText(R.string.food_Calorie_food_size_203);
        size_28 = (String) x.getText(R.string.food_Calorie_food_size_204);
        size_29 = (String) x.getText(R.string.food_Calorie_food_size_205);
        size_30 = (String) x.getText(R.string.food_Calorie_food_size_206);
        size_31 = (String) x.getText(R.string.food_Calorie_food_size_207);
        size_32 = (String) x.getText(R.string.food_Calorie_food_size_208);
        size_33 = (String) x.getText(R.string.food_Calorie_food_size_209);
        size_34 = (String) x.getText(R.string.food_Calorie_food_size_210);
        size_35 = (String) x.getText(R.string.food_Calorie_food_size_211);
        size_36 = (String) x.getText(R.string.food_Calorie_food_size_212);
        size_37 = (String) x.getText(R.string.food_Calorie_food_size_213);
        size_38 = (String) x.getText(R.string.food_Calorie_food_size_214);
        size_39 = (String) x.getText(R.string.food_Calorie_food_size_215);
        size_40 = (String) x.getText(R.string.food_Calorie_food_size_216);
        size_41 = (String) x.getText(R.string.food_Calorie_food_size_217);
        size_42 = (String) x.getText(R.string.food_Calorie_food_size_218);
        size_43 = (String) x.getText(R.string.food_Calorie_food_size_219);
        size_44 = (String) x.getText(R.string.food_Calorie_food_size_220);
        size_45 = (String) x.getText(R.string.food_Calorie_food_size_221);
        size_46 = (String) x.getText(R.string.food_Calorie_food_size_222);
        size_47 = (String) x.getText(R.string.food_Calorie_food_size_223);
        size_48 = (String) x.getText(R.string.food_Calorie_food_size_224);
        size_49 = (String) x.getText(R.string.food_Calorie_food_size_225);
        size_50 = (String) x.getText(R.string.food_Calorie_food_size_226);
        size_51 = (String) x.getText(R.string.food_Calorie_food_size_227);
        size_52 = (String) x.getText(R.string.food_Calorie_food_size_228);
        size_53 = (String) x.getText(R.string.food_Calorie_food_size_229);
        size_54 = (String) x.getText(R.string.food_Calorie_food_size_230);
        size_55 = (String) x.getText(R.string.food_Calorie_food_size_231);
        size_56 = (String) x.getText(R.string.food_Calorie_food_size_232);
        size_57 = (String) x.getText(R.string.food_Calorie_food_size_233);
        size_58 = (String) x.getText(R.string.food_Calorie_food_size_234);
        size_59 = (String) x.getText(R.string.food_Calorie_food_size_235);
        size_60 = (String) x.getText(R.string.food_Calorie_food_size_236);
        size_61 = (String) x.getText(R.string.food_Calorie_food_size_237);
        size_62 = (String) x.getText(R.string.food_Calorie_food_size_238);
        size_63 = (String) x.getText(R.string.food_Calorie_food_size_239);
        size_64 = (String) x.getText(R.string.food_Calorie_food_size_240);
        size_65 = (String) x.getText(R.string.food_Calorie_food_size_241);
        size_66 = (String) x.getText(R.string.food_Calorie_food_size_242);
        size_67 = (String) x.getText(R.string.food_Calorie_food_size_243);
        size_68 = (String) x.getText(R.string.food_Calorie_food_size_244);
        size_69 = (String) x.getText(R.string.food_Calorie_food_size_245);
        size_70 = (String) x.getText(R.string.food_Calorie_food_size_246);
        size_71 = (String) x.getText(R.string.food_Calorie_food_size_247);
        size_72 = (String) x.getText(R.string.food_Calorie_food_size_248);
        size_73 = (String) x.getText(R.string.food_Calorie_food_size_249);
        size_74 = (String) x.getText(R.string.food_Calorie_food_size_250);
        size_75 = (String) x.getText(R.string.food_Calorie_food_size_251);
        size_76 = (String) x.getText(R.string.food_Calorie_food_size_252);
        size_77 = (String) x.getText(R.string.food_Calorie_food_size_253);
        size_78 = (String) x.getText(R.string.food_Calorie_food_size_254);
        size_79 = (String) x.getText(R.string.food_Calorie_food_size_255);
        size_80 = (String) x.getText(R.string.food_Calorie_food_size_256);
        size_81 = (String) x.getText(R.string.food_Calorie_food_size_257);
        size_82 = (String) x.getText(R.string.food_Calorie_food_size_258);
        size_83 = (String) x.getText(R.string.food_Calorie_food_size_259);
        size_84 = (String) x.getText(R.string.food_Calorie_food_size_260);
        size_85 = (String) x.getText(R.string.food_Calorie_food_size_261);
        size_86 = (String) x.getText(R.string.food_Calorie_food_size_262);
        size_87 = (String) x.getText(R.string.food_Calorie_food_size_263);
        size_88 = (String) x.getText(R.string.food_Calorie_food_size_264);
        size_89 = (String) x.getText(R.string.food_Calorie_food_size_265);
        size_90 = (String) x.getText(R.string.food_Calorie_food_size_266);
        size_91 = (String) x.getText(R.string.food_Calorie_food_size_267);
        size_92 = (String) x.getText(R.string.food_Calorie_food_size_268);
        size_93 = (String) x.getText(R.string.food_Calorie_food_size_269);
        size_94 = (String) x.getText(R.string.food_Calorie_food_size_270);
        size_95 = (String) x.getText(R.string.food_Calorie_food_size_271);
        size_96 = (String) x.getText(R.string.food_Calorie_food_size_272);
        size_97 = (String) x.getText(R.string.food_Calorie_food_size_273);
        size_98 = (String) x.getText(R.string.food_Calorie_food_size_274);
        size_99 = (String) x.getText(R.string.food_Calorie_food_size_275);
        size_100 = (String) x.getText(R.string.food_Calorie_food_size_276);
        size_101 = (String) x.getText(R.string.food_Calorie_food_size_277);
        size_102 = (String) x.getText(R.string.food_Calorie_food_size_278);
        size_103 = (String) x.getText(R.string.food_Calorie_food_size_279);
        size_104 = (String) x.getText(R.string.food_Calorie_food_size_280);
        size_105 = (String) x.getText(R.string.food_Calorie_food_size_281);
        size_106 = (String) x.getText(R.string.food_Calorie_food_size_282);
        size_107 = (String) x.getText(R.string.food_Calorie_food_size_283);
        size_108 = (String) x.getText(R.string.food_Calorie_food_size_284);
        size_109 = (String) x.getText(R.string.food_Calorie_food_size_285);
        size_110 = (String) x.getText(R.string.food_Calorie_food_size_286);
        size_111 = (String) x.getText(R.string.food_Calorie_food_size_2);
        size_112 = (String) x.getText(R.string.food_Calorie_food_size_3);
        size_113 = (String) x.getText(R.string.food_Calorie_food_size_4);
        size_114 = (String) x.getText(R.string.food_Calorie_food_size_5);
        size_115 = (String) x.getText(R.string.food_Calorie_food_size_6);
        size_116 = (String) x.getText(R.string.food_Calorie_food_size_7);
        size_117 = (String) x.getText(R.string.food_Calorie_food_size_8);
        size_118 = (String) x.getText(R.string.food_Calorie_food_size_9);
        size_119 = (String) x.getText(R.string.food_Calorie_food_size_10);
        size_120 = (String) x.getText(R.string.food_Calorie_food_size_11);
        size_121 = (String) x.getText(R.string.food_Calorie_food_size_12);
        size_122 = (String) x.getText(R.string.food_Calorie_food_size_13);
        size_123 = (String) x.getText(R.string.food_Calorie_food_size_14);
        size_124 = (String) x.getText(R.string.food_Calorie_food_size_15);
        size_125 = (String) x.getText(R.string.food_Calorie_food_size_16);
        size_126 = (String) x.getText(R.string.food_Calorie_food_size_17);
        size_127 = (String) x.getText(R.string.food_Calorie_food_size_18);
        size_128 = (String) x.getText(R.string.food_Calorie_food_size_19);
        size_129 = (String) x.getText(R.string.food_Calorie_food_size_20);
        size_130 = (String) x.getText(R.string.food_Calorie_food_size_21);
        size_131 = (String) x.getText(R.string.food_Calorie_food_size_22);
        size_132 = (String) x.getText(R.string.food_Calorie_food_size_23);
        size_133 = (String) x.getText(R.string.food_Calorie_food_size_24);
        size_134 = (String) x.getText(R.string.food_Calorie_food_size_25);
        size_135 = (String) x.getText(R.string.food_Calorie_food_size_26);
        size_136 = (String) x.getText(R.string.food_Calorie_food_size_27);
        size_137 = (String) x.getText(R.string.food_Calorie_food_size_28);
        size_138 = (String) x.getText(R.string.food_Calorie_food_size_29);
        size_139 = (String) x.getText(R.string.food_Calorie_food_size_30);
        size_140 = (String) x.getText(R.string.food_Calorie_food_size_31);
        size_141 = (String) x.getText(R.string.food_Calorie_food_size_32);
        size_142 = (String) x.getText(R.string.food_Calorie_food_size_33);
        size_143 = (String) x.getText(R.string.food_Calorie_food_size_34);
        size_144 = (String) x.getText(R.string.food_Calorie_food_size_35);
        size_145 = (String) x.getText(R.string.food_Calorie_food_size_36);
        size_146 = (String) x.getText(R.string.food_Calorie_food_size_37);
        size_147 = (String) x.getText(R.string.food_Calorie_food_size_38);
        size_148 = (String) x.getText(R.string.food_Calorie_food_size_39);
        size_149 = (String) x.getText(R.string.food_Calorie_food_size_40);
        size_150 = (String) x.getText(R.string.food_Calorie_food_size_41);
        size_151 = (String) x.getText(R.string.food_Calorie_food_size_42);
        size_152 = (String) x.getText(R.string.food_Calorie_food_size_43);
        size_153 = (String) x.getText(R.string.food_Calorie_food_size_44);
        size_154 = (String) x.getText(R.string.food_Calorie_food_size_45);
        size_155 = (String) x.getText(R.string.food_Calorie_food_size_46);
        size_156 = (String) x.getText(R.string.food_Calorie_food_size_47);
        size_157 = (String) x.getText(R.string.food_Calorie_food_size_48);
        size_158 = (String) x.getText(R.string.food_Calorie_food_size_49);
        size_159 = (String) x.getText(R.string.food_Calorie_food_size_50);
        size_160 = (String) x.getText(R.string.food_Calorie_food_size_51);
        size_161 = (String) x.getText(R.string.food_Calorie_food_size_52);
        size_162 = (String) x.getText(R.string.food_Calorie_food_size_53);
        size_163 = (String) x.getText(R.string.food_Calorie_food_size_54);
        size_164 = (String) x.getText(R.string.food_Calorie_food_size_55);
        size_165 = (String) x.getText(R.string.food_Calorie_food_size_55);
        size_166 = (String) x.getText(R.string.food_Calorie_food_size_56);
        size_167 = (String) x.getText(R.string.food_Calorie_food_size_57);
        size_168 = (String) x.getText(R.string.food_Calorie_food_size_58);
        size_169 = (String) x.getText(R.string.food_Calorie_food_size_59);
        size_170 = (String) x.getText(R.string.food_Calorie_food_size_60);
        size_171 = (String) x.getText(R.string.food_Calorie_food_size_61);
        size_172 = (String) x.getText(R.string.food_Calorie_food_size_62);
        size_173 = (String) x.getText(R.string.food_Calorie_food_size_63);
        size_174 = (String) x.getText(R.string.food_Calorie_food_size_64);
        size_175 = (String) x.getText(R.string.food_Calorie_food_size_65);
        size_176 = (String) x.getText(R.string.food_Calorie_food_size_66);
        size_177 = (String) x.getText(R.string.food_Calorie_food_size_67);
        size_178 = (String) x.getText(R.string.food_Calorie_food_size_68);
        size_179 = (String) x.getText(R.string.food_Calorie_food_size_69);
        size_180 = (String) x.getText(R.string.food_Calorie_food_size_70);
        size_181 = (String) x.getText(R.string.food_Calorie_food_size_71);
        size_182 = (String) x.getText(R.string.food_Calorie_food_size_72);
        size_183 = (String) x.getText(R.string.food_Calorie_food_size_73);
        size_184 = (String) x.getText(R.string.food_Calorie_food_size_74);
        size_185 = (String) x.getText(R.string.food_Calorie_food_size_75);
        size_186 = (String) x.getText(R.string.food_Calorie_food_size_76);
        size_187 = (String) x.getText(R.string.food_Calorie_food_size_77);
        size_188 = (String) x.getText(R.string.food_Calorie_food_size_78);
        size_189 = (String) x.getText(R.string.food_Calorie_food_size_79);
        size_190 = (String) x.getText(R.string.food_Calorie_food_size_80);
        size_191 = (String) x.getText(R.string.food_Calorie_food_size_81);
        size_192 = (String) x.getText(R.string.food_Calorie_food_size_82);
        size_193 = (String) x.getText(R.string.food_Calorie_food_size_83);
        size_194 = (String) x.getText(R.string.food_Calorie_food_size_84);
        size_195 = (String) x.getText(R.string.food_Calorie_food_size_85);
        size_196 = (String) x.getText(R.string.food_Calorie_food_size_86);
        size_197 = (String) x.getText(R.string.food_Calorie_food_size_87);
        size_198 = (String) x.getText(R.string.food_Calorie_food_size_88);
        size_199 = (String) x.getText(R.string.food_Calorie_food_size_89);
        size_200 = (String) x.getText(R.string.food_Calorie_food_size_90);
        size_201 = (String) x.getText(R.string.food_Calorie_food_size_91);
        size_202 = (String) x.getText(R.string.food_Calorie_food_size_92);
        size_203 = (String) x.getText(R.string.food_Calorie_food_size_93);
        size_204 = (String) x.getText(R.string.food_Calorie_food_size_94);
        size_205 = (String) x.getText(R.string.food_Calorie_food_size_95);
        size_206 = (String) x.getText(R.string.food_Calorie_food_size_96);
        size_207 = (String) x.getText(R.string.food_Calorie_food_size_97);
        size_208 = (String) x.getText(R.string.food_Calorie_food_size_98);
        size_209 = (String) x.getText(R.string.food_Calorie_food_size_99);
        size_210 = (String) x.getText(R.string.food_Calorie_food_size_100);
        size_211 = (String) x.getText(R.string.food_Calorie_food_size_101);
        size_212 = (String) x.getText(R.string.food_Calorie_food_size_102);
        size_213 = (String) x.getText(R.string.food_Calorie_food_size_103);
        size_215 = (String) x.getText(R.string.food_Calorie_food_size_105);
        size_216 = (String) x.getText(R.string.food_Calorie_food_size_106);
        size_217 = (String) x.getText(R.string.food_Calorie_food_size_107);
        size_218 = (String) x.getText(R.string.food_Calorie_food_size_108);
        size_219 = (String) x.getText(R.string.food_Calorie_food_size_109);
        size_220 = (String) x.getText(R.string.food_Calorie_food_size_110);
        size_221 = (String) x.getText(R.string.food_Calorie_food_size_111);
        size_222 = (String) x.getText(R.string.food_Calorie_food_size_112);
        size_223 = (String) x.getText(R.string.food_Calorie_food_size_113);
        size_224 = (String) x.getText(R.string.food_Calorie_food_size_114);
        size_225 = (String) x.getText(R.string.food_Calorie_food_size_115);
        size_226 = (String) x.getText(R.string.food_Calorie_food_size_116);
        size_227 = (String) x.getText(R.string.food_Calorie_food_size_117);
        size_228 = (String) x.getText(R.string.food_Calorie_food_size_118);
        size_229 = (String) x.getText(R.string.food_Calorie_food_size_119);
        size_230 = (String) x.getText(R.string.food_Calorie_food_size_120);
        size_231 = (String) x.getText(R.string.food_Calorie_food_size_121);
        size_232 = (String) x.getText(R.string.food_Calorie_food_size_122);
        size_233 = (String) x.getText(R.string.food_Calorie_food_size_123);
        size_234 = (String) x.getText(R.string.food_Calorie_food_size_124);
        size_235 = (String) x.getText(R.string.food_Calorie_food_size_125);
        size_236 = (String) x.getText(R.string.food_Calorie_food_size_127);
        size_237 = (String) x.getText(R.string.food_Calorie_food_size_128);
        size_238 = (String) x.getText(R.string.food_Calorie_food_size_129);
        size_239 = (String) x.getText(R.string.food_Calorie_food_size_130);
        size_240 = (String) x.getText(R.string.food_Calorie_food_size_131);
        size_241 = (String) x.getText(R.string.food_Calorie_food_size_132);
        size_242 = (String) x.getText(R.string.food_Calorie_food_size_133);
        size_243 = (String) x.getText(R.string.food_Calorie_food_size_134);
        size_244 = (String) x.getText(R.string.food_Calorie_food_size_135);
        size_245 = (String) x.getText(R.string.food_Calorie_food_size_136);
        size_246 = (String) x.getText(R.string.food_Calorie_food_size_137);
        size_247 = (String) x.getText(R.string.food_Calorie_food_size_138);
        size_248 = (String) x.getText(R.string.food_Calorie_food_size_139);
        size_249 = (String) x.getText(R.string.food_Calorie_food_size_140);
        size_250 = (String) x.getText(R.string.food_Calorie_food_size_141);
        size_251 = (String) x.getText(R.string.food_Calorie_food_size_142);
        size_252 = (String) x.getText(R.string.food_Calorie_food_size_143);
        size_253 = (String) x.getText(R.string.food_Calorie_food_size_144);
        size_254 = (String) x.getText(R.string.food_Calorie_food_size_145);
        size_255 = (String) x.getText(R.string.food_Calorie_food_size_146);
        size_256 = (String) x.getText(R.string.food_Calorie_food_size_147);
        size_257 = (String) x.getText(R.string.food_Calorie_food_size_148);
        size_258 = (String) x.getText(R.string.food_Calorie_food_size_149);
        size_259 = (String) x.getText(R.string.food_Calorie_food_size_150);
        size_260 = (String) x.getText(R.string.food_Calorie_food_size_151);
        size_261 = (String) x.getText(R.string.food_Calorie_food_size_152);
        size_262 = (String) x.getText(R.string.food_Calorie_food_size_153);
        size_263 = (String) x.getText(R.string.food_Calorie_food_size_154);
        size_264 = (String) x.getText(R.string.food_Calorie_food_size_155);
        size_265 = (String) x.getText(R.string.food_Calorie_food_size_156);
        size_266 = (String) x.getText(R.string.food_Calorie_food_size_157);
        size_267 = (String) x.getText(R.string.food_Calorie_food_size_158);
        size_268 = (String) x.getText(R.string.food_Calorie_food_size_159);
        size_269 = (String) x.getText(R.string.food_Calorie_food_size_160);
        size_270 = (String) x.getText(R.string.food_Calorie_food_size_161);
        size_271 = (String) x.getText(R.string.food_Calorie_food_size_162);
        size_272 = (String) x.getText(R.string.food_Calorie_food_size_163);
        size_273 = (String) x.getText(R.string.food_Calorie_food_size_164);
        size_274 = (String) x.getText(R.string.food_Calorie_food_size_165);
        size_275 = (String) x.getText(R.string.food_Calorie_food_size_166);
        size_276 = (String) x.getText(R.string.food_Calorie_food_size_167);
        size_277 = (String) x.getText(R.string.food_Calorie_food_size_168);
        size_278 = (String) x.getText(R.string.food_Calorie_food_size_169);
        size_279 = (String) x.getText(R.string.food_Calorie_food_size_170);
        size_280 = (String) x.getText(R.string.food_Calorie_food_size_171);
        size_281 = (String) x.getText(R.string.food_Calorie_food_size_172);
        size_282 = (String) x.getText(R.string.food_Calorie_food_size_173);
        size_283 = (String) x.getText(R.string.food_Calorie_food_size_174);


        //id colery ha


        calery_1 = (String) x.getText(R.string.food_Calorie_food_caleri_1);
        calery_2 = (String) x.getText(R.string.food_Calorie_food_caleri_178);
        calery_3 = (String) x.getText(R.string.food_Calorie_food_caleri_179);
        calery_4 = (String) x.getText(R.string.food_Calorie_food_caleri_180);
        calery_5 = (String) x.getText(R.string.food_Calorie_food_caleri_181);
        calery_6 = (String) x.getText(R.string.food_Calorie_food_caleri_182);
        calery_7 = (String) x.getText(R.string.food_Calorie_food_caleri_183);
        calery_8 = (String) x.getText(R.string.food_Calorie_food_caleri_184);
        calery_9 = (String) x.getText(R.string.food_Calorie_food_caleri_185);
        calery_10 = (String) x.getText(R.string.food_Calorie_food_caleri_186);
        calery_11 = (String) x.getText(R.string.food_Calorie_food_caleri_187);
        calery_12 = (String) x.getText(R.string.food_Calorie_food_caleri_188);
        calery_13 = (String) x.getText(R.string.food_Calorie_food_caleri_189);
        calery_14 = (String) x.getText(R.string.food_Calorie_food_caleri_190);
        calery_15 = (String) x.getText(R.string.food_Calorie_food_caleri_191);
        calery_16 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_17 = (String) x.getText(R.string.food_Calorie_food_caleri_193);
        calery_18 = (String) x.getText(R.string.food_Calorie_food_caleri_194);
        calery_19 = (String) x.getText(R.string.food_Calorie_food_caleri_195);
        calery_20 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_21 = (String) x.getText(R.string.food_Calorie_food_caleri_16);
        calery_22 = (String) x.getText(R.string.food_Calorie_food_caleri_198);
        calery_23 = (String) x.getText(R.string.food_Calorie_food_caleri_199);
        calery_24 = (String) x.getText(R.string.food_Calorie_food_caleri_200);
        calery_25 = (String) x.getText(R.string.food_Calorie_food_caleri_201);
        calery_26 = (String) x.getText(R.string.food_Calorie_food_caleri_202);
        calery_27 = (String) x.getText(R.string.food_Calorie_food_caleri_203);
        calery_28 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_29 = (String) x.getText(R.string.food_Calorie_food_caleri_205);
        calery_30 = (String) x.getText(R.string.food_Calorie_food_caleri_206);
        calery_31 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_32 = (String) x.getText(R.string.food_Calorie_food_caleri_208);
        calery_33 = (String) x.getText(R.string.food_Calorie_food_caleri_209);
        calery_34 = (String) x.getText(R.string.food_Calorie_food_caleri_1);
        calery_35 = (String) x.getText(R.string.food_Calorie_food_caleri_15);
        calery_36 = (String) x.getText(R.string.food_Calorie_food_caleri_212);
        calery_37 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_38 = (String) x.getText(R.string.food_Calorie_food_caleri_214);
        calery_39 = (String) x.getText(R.string.food_Calorie_food_caleri_42);
        calery_40 = (String) x.getText(R.string.food_Calorie_food_caleri_216);
        calery_41 = (String) x.getText(R.string.food_Calorie_food_caleri_217);
        calery_42 = (String) x.getText(R.string.food_Calorie_food_caleri_218);
        calery_43 = (String) x.getText(R.string.food_Calorie_food_caleri_219);
        calery_44 = (String) x.getText(R.string.food_Calorie_food_caleri_220);
        calery_45 = (String) x.getText(R.string.food_Calorie_food_caleri_1);
        calery_46 = (String) x.getText(R.string.food_Calorie_food_caleri_222);
        calery_47 = (String) x.getText(R.string.food_Calorie_food_caleri_223);
        calery_48 = (String) x.getText(R.string.food_Calorie_food_caleri_224);
        calery_49 = (String) x.getText(R.string.food_Calorie_food_caleri_225);
        calery_50 = (String) x.getText(R.string.food_Calorie_food_caleri_226);
        calery_51 = (String) x.getText(R.string.food_Calorie_food_caleri_227);
        calery_52 = (String) x.getText(R.string.food_Calorie_food_caleri_228);
        calery_53 = (String) x.getText(R.string.food_Calorie_food_caleri_229);
        calery_54 = (String) x.getText(R.string.food_Calorie_food_caleri_230);
        calery_55 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_56 = (String) x.getText(R.string.food_Calorie_food_caleri_232);
        calery_57 = (String) x.getText(R.string.food_Calorie_food_caleri_233);
        calery_58 = (String) x.getText(R.string.food_Calorie_food_caleri_10);
        calery_59 = (String) x.getText(R.string.food_Calorie_food_caleri_235);
        calery_60 = (String) x.getText(R.string.food_Calorie_food_caleri_236);
        calery_61 = (String) x.getText(R.string.food_Calorie_food_caleri_237);
        calery_62 = (String) x.getText(R.string.food_Calorie_food_caleri_238);
        calery_63 = (String) x.getText(R.string.food_Calorie_food_caleri_239);
        calery_64 = (String) x.getText(R.string.food_Calorie_food_caleri_240);
        calery_65 = (String) x.getText(R.string.food_Calorie_food_caleri_241);
        calery_66 = (String) x.getText(R.string.food_Calorie_food_caleri_242);
        calery_67 = (String) x.getText(R.string.food_Calorie_food_caleri_243);
        calery_68 = (String) x.getText(R.string.food_Calorie_food_caleri_244);
        calery_69 = (String) x.getText(R.string.food_Calorie_food_caleri_245);
        calery_70 = (String) x.getText(R.string.food_Calorie_food_caleri_246);
        calery_71 = (String) x.getText(R.string.food_Calorie_food_caleri_247);
        calery_72 = (String) x.getText(R.string.food_Calorie_food_caleri_248);
        calery_73 = (String) x.getText(R.string.food_Calorie_food_caleri_249);
        calery_74 = (String) x.getText(R.string.food_Calorie_food_caleri_250);
        calery_75 = (String) x.getText(R.string.food_Calorie_food_caleri_251);
        calery_76 = (String) x.getText(R.string.food_Calorie_food_caleri_252);
        calery_77 = (String) x.getText(R.string.food_Calorie_food_caleri_253);
        calery_78 = (String) x.getText(R.string.food_Calorie_food_caleri_254);
        calery_79 = (String) x.getText(R.string.food_Calorie_food_caleri_255);
        calery_80 = (String) x.getText(R.string.food_Calorie_food_caleri_1);
        calery_81 = (String) x.getText(R.string.food_Calorie_food_caleri_257);
        calery_82 = (String) x.getText(R.string.food_Calorie_food_caleri_258);
        calery_83 = (String) x.getText(R.string.food_Calorie_food_caleri_259);
        calery_84 = (String) x.getText(R.string.food_Calorie_food_caleri_260);
        calery_85 = (String) x.getText(R.string.food_Calorie_food_caleri_261);
        calery_86 = (String) x.getText(R.string.food_Calorie_food_caleri_1);
        calery_87 = (String) x.getText(R.string.food_Calorie_food_caleri_263);
        calery_88 = (String) x.getText(R.string.food_Calorie_food_caleri_264);
        calery_89 = (String) x.getText(R.string.food_Calorie_food_caleri_265);
        calery_90 = (String) x.getText(R.string.food_Calorie_food_caleri_266);
        calery_91 = (String) x.getText(R.string.food_Calorie_food_caleri_267);
        calery_92 = (String) x.getText(R.string.food_Calorie_food_caleri_268);
        calery_93 = (String) x.getText(R.string.food_Calorie_food_caleri_269);
        calery_94 = (String) x.getText(R.string.food_Calorie_food_caleri_270);
        calery_95 = (String) x.getText(R.string.food_Calorie_food_caleri_271);
        calery_96 = (String) x.getText(R.string.food_Calorie_food_caleri_272);
        calery_97 = (String) x.getText(R.string.food_Calorie_food_caleri_273);
        calery_98 = (String) x.getText(R.string.food_Calorie_food_caleri_274);
        calery_99 = (String) x.getText(R.string.food_Calorie_food_caleri_275);
        calery_100 = (String) x.getText(R.string.food_Calorie_food_caleri_276);
        calery_101 = (String) x.getText(R.string.food_Calorie_food_caleri_277);
        calery_102 = (String) x.getText(R.string.food_Calorie_food_caleri_278);
        calery_103 = (String) x.getText(R.string.food_Calorie_food_caleri_279);
        calery_104 = (String) x.getText(R.string.food_Calorie_food_caleri_280);
        calery_105 = (String) x.getText(R.string.food_Calorie_food_caleri_281);
        calery_106 = (String) x.getText(R.string.food_Calorie_food_caleri_282);
        calery_107 = (String) x.getText(R.string.food_Calorie_food_caleri_283);
        calery_108 = (String) x.getText(R.string.food_Calorie_food_caleri_284);
        calery_109 = (String) x.getText(R.string.food_Calorie_food_caleri_285);
        calery_110 = (String) x.getText(R.string.food_Calorie_food_caleri_286);
        calery_111 = (String) x.getText(R.string.food_Calorie_food_caleri_2);
        calery_112 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_113 = (String) x.getText(R.string.food_Calorie_food_caleri_4);
        calery_114 = (String) x.getText(R.string.food_Calorie_food_caleri_5);
        calery_115 = (String) x.getText(R.string.food_Calorie_food_caleri_6);
        calery_116 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_117 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_118 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_119 = (String) x.getText(R.string.food_Calorie_food_caleri_10);
        calery_120 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_121 = (String) x.getText(R.string.food_Calorie_food_caleri_12);
        calery_122 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_123 = (String) x.getText(R.string.food_Calorie_food_caleri_14);
        calery_124 = (String) x.getText(R.string.food_Calorie_food_caleri_15);
        calery_125 = (String) x.getText(R.string.food_Calorie_food_caleri_16);
        calery_126 = (String) x.getText(R.string.food_Calorie_food_caleri_2);
        calery_127 = (String) x.getText(R.string.food_Calorie_food_caleri_18);
        calery_128 = (String) x.getText(R.string.food_Calorie_food_caleri_19);
        calery_129 = (String) x.getText(R.string.food_Calorie_food_caleri_20);
        calery_130 = (String) x.getText(R.string.food_Calorie_food_caleri_21);
        calery_131 = (String) x.getText(R.string.food_Calorie_food_caleri_22);
        calery_132 = (String) x.getText(R.string.food_Calorie_food_caleri_23);
        calery_133 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_134 = (String) x.getText(R.string.food_Calorie_food_caleri_25);
        calery_135 = (String) x.getText(R.string.food_Calorie_food_caleri_26);
        calery_136 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_137 = (String) x.getText(R.string.food_Calorie_food_caleri_28);
        calery_138 = (String) x.getText(R.string.food_Calorie_food_caleri_29);
        calery_139 = (String) x.getText(R.string.food_Calorie_food_caleri_30);
        calery_140 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_141 = (String) x.getText(R.string.food_Calorie_food_caleri_4);
        calery_142 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_143 = (String) x.getText(R.string.food_Calorie_food_caleri_12);
        calery_144 = (String) x.getText(R.string.food_Calorie_food_caleri_35);
        calery_145 = (String) x.getText(R.string.food_Calorie_food_caleri_36);
        calery_146 = (String) x.getText(R.string.food_Calorie_food_caleri_37);
        calery_147 = (String) x.getText(R.string.food_Calorie_food_caleri_37);
        calery_148 = (String) x.getText(R.string.food_Calorie_food_caleri_39);
        calery_149 = (String) x.getText(R.string.food_Calorie_food_caleri_40);
        calery_150 = (String) x.getText(R.string.food_Calorie_food_caleri_18);
        calery_151 = (String) x.getText(R.string.food_Calorie_food_caleri_42);
        calery_152 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_153 = (String) x.getText(R.string.food_Calorie_food_caleri_44);
        calery_154 = (String) x.getText(R.string.food_Calorie_food_caleri_45);
        calery_155 = (String) x.getText(R.string.food_Calorie_food_caleri_1);
        calery_156 = (String) x.getText(R.string.food_Calorie_food_caleri_5);
        calery_157 = (String) x.getText(R.string.food_Calorie_food_caleri_6);
        calery_158 = (String) x.getText(R.string.food_Calorie_food_caleri_49);
        calery_159 = (String) x.getText(R.string.food_Calorie_food_caleri_50);
        calery_160 = (String) x.getText(R.string.food_Calorie_food_caleri_51);
        calery_161 = (String) x.getText(R.string.food_Calorie_food_caleri_52);
        calery_162 = (String) x.getText(R.string.food_Calorie_food_caleri_53);
        calery_163 = (String) x.getText(R.string.food_Calorie_food_caleri_54);
        calery_164 = (String) x.getText(R.string.food_Calorie_food_caleri_55);
        calery_165 = (String) x.getText(R.string.food_Calorie_food_caleri_16);
        calery_166 = (String) x.getText(R.string.food_Calorie_food_caleri_57);
        calery_167 = (String) x.getText(R.string.food_Calorie_food_caleri_58);
        calery_168 = (String) x.getText(R.string.food_Calorie_food_caleri_10);
        calery_169 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_170 = (String) x.getText(R.string.food_Calorie_food_caleri_61);
        calery_171 = (String) x.getText(R.string.food_Calorie_food_caleri_62);
        calery_172 = (String) x.getText(R.string.food_Calorie_food_caleri_25);
        calery_173 = (String) x.getText(R.string.food_Calorie_food_caleri_64);
        calery_174 = (String) x.getText(R.string.food_Calorie_food_caleri_42);
        calery_175 = (String) x.getText(R.string.food_Calorie_food_caleri_66);
        calery_176 = (String) x.getText(R.string.food_Calorie_food_caleri_67);
        calery_177 = (String) x.getText(R.string.food_Calorie_food_caleri_68);
        calery_178 = (String) x.getText(R.string.food_Calorie_food_caleri_69);
        calery_179 = (String) x.getText(R.string.food_Calorie_food_caleri_69);
        calery_180 = (String) x.getText(R.string.food_Calorie_food_caleri_71);
        calery_181 = (String) x.getText(R.string.food_Calorie_food_caleri_72);
        calery_182 = (String) x.getText(R.string.food_Calorie_food_caleri_73);
        calery_183 = (String) x.getText(R.string.food_Calorie_food_caleri_74);
        calery_184 = (String) x.getText(R.string.food_Calorie_food_caleri_69);
        calery_185 = (String) x.getText(R.string.food_Calorie_food_caleri_76);
        calery_186 = (String) x.getText(R.string.food_Calorie_food_caleri_77);
        calery_187 = (String) x.getText(R.string.food_Calorie_food_caleri_78);
        calery_188 = (String) x.getText(R.string.food_Calorie_food_caleri_79);
        calery_189 = (String) x.getText(R.string.food_Calorie_food_caleri_6);
        calery_190 = (String) x.getText(R.string.food_Calorie_food_caleri_81);
        calery_191 = (String) x.getText(R.string.food_Calorie_food_caleri_82);
        calery_192 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_193 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_194 = (String) x.getText(R.string.food_Calorie_food_caleri_85);
        calery_195 = (String) x.getText(R.string.food_Calorie_food_caleri_86);
        calery_196 = (String) x.getText(R.string.food_Calorie_food_caleri_87);
        calery_197 = (String) x.getText(R.string.food_Calorie_food_caleri_88);
        calery_198 = (String) x.getText(R.string.food_Calorie_food_caleri_89);
        calery_199 = (String) x.getText(R.string.food_Calorie_food_caleri_90);
        calery_200 = (String) x.getText(R.string.food_Calorie_food_caleri_91);
        calery_201 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_202 = (String) x.getText(R.string.food_Calorie_food_caleri_93);
        calery_203 = (String) x.getText(R.string.food_Calorie_food_caleri_18);
        calery_204 = (String) x.getText(R.string.food_Calorie_food_caleri_25);
        calery_205 = (String) x.getText(R.string.food_Calorie_food_caleri_96);
        calery_206 = (String) x.getText(R.string.food_Calorie_food_caleri_97);
        calery_207 = (String) x.getText(R.string.food_Calorie_food_caleri_98);
        calery_208 = (String) x.getText(R.string.food_Calorie_food_caleri_99);
        calery_209 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_210 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_211 = (String) x.getText(R.string.food_Calorie_food_caleri_102);
        calery_212 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_213 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_214 = (String) x.getText(R.string.food_Calorie_food_caleri_10);
        calery_215 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_216 = (String) x.getText(R.string.food_Calorie_food_caleri_15);
        calery_217 = (String) x.getText(R.string.food_Calorie_food_caleri_19);
        calery_218 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_219 = (String) x.getText(R.string.food_Calorie_food_caleri_25);
        calery_220 = (String) x.getText(R.string.food_Calorie_food_caleri_111);
        calery_221 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_222 = (String) x.getText(R.string.food_Calorie_food_caleri_113);
        calery_223 = (String) x.getText(R.string.food_Calorie_food_caleri_114);
        calery_224 = (String) x.getText(R.string.food_Calorie_food_caleri_115);
        calery_225 = (String) x.getText(R.string.food_Calorie_food_caleri_116);
        calery_226 = (String) x.getText(R.string.food_Calorie_food_caleri_10);
        calery_227 = (String) x.getText(R.string.food_Calorie_food_caleri_118);
        calery_228 = (String) x.getText(R.string.food_Calorie_food_caleri_10);
        calery_229 = (String) x.getText(R.string.food_Calorie_food_caleri_120);
        calery_230 = (String) x.getText(R.string.food_Calorie_food_caleri_121);
        calery_231 = (String) x.getText(R.string.food_Calorie_food_caleri_122);
        calery_232 = (String) x.getText(R.string.food_Calorie_food_caleri_12);
        calery_233 = (String) x.getText(R.string.food_Calorie_food_caleri_124);
        calery_234 = (String) x.getText(R.string.food_Calorie_food_caleri_29);
        calery_235 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_236 = (String) x.getText(R.string.food_Calorie_food_caleri_127);
        calery_237 = (String) x.getText(R.string.food_Calorie_food_caleri_128);
        calery_238 = (String) x.getText(R.string.food_Calorie_food_caleri_25);
        calery_239 = (String) x.getText(R.string.food_Calorie_food_caleri_132);
        calery_240 = (String) x.getText(R.string.food_Calorie_food_caleri_133);
        calery_241 = (String) x.getText(R.string.food_Calorie_food_caleri_69);
        calery_242 = (String) x.getText(R.string.food_Calorie_food_caleri_136);
        calery_243 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_244 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_245 = (String) x.getText(R.string.food_Calorie_food_caleri_19);
        calery_246 = (String) x.getText(R.string.food_Calorie_food_caleri_140);
        calery_247 = (String) x.getText(R.string.food_Calorie_food_caleri_141);
        calery_248 = (String) x.getText(R.string.food_Calorie_food_caleri_142);
        calery_249 = (String) x.getText(R.string.food_Calorie_food_caleri_143);
        calery_250 = (String) x.getText(R.string.food_Calorie_food_caleri_144);
        calery_251 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_252 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_253 = (String) x.getText(R.string.food_Calorie_food_caleri_147);
        calery_254 = (String) x.getText(R.string.food_Calorie_food_caleri_25);
        calery_255 = (String) x.getText(R.string.food_Calorie_food_caleri_3);
        calery_256 = (String) x.getText(R.string.food_Calorie_food_caleri_27);
        calery_257 = (String) x.getText(R.string.food_Calorie_food_caleri_151);
        calery_258 = (String) x.getText(R.string.food_Calorie_food_caleri_152);
        calery_259 = (String) x.getText(R.string.food_Calorie_food_caleri_153);
        calery_260 = (String) x.getText(R.string.food_Calorie_food_caleri_154);
        calery_261 = (String) x.getText(R.string.food_Calorie_food_caleri_155);
        calery_262 = (String) x.getText(R.string.food_Calorie_food_caleri_156);
        calery_263 = (String) x.getText(R.string.food_Calorie_food_caleri_157);
        calery_264 = (String) x.getText(R.string.food_Calorie_food_caleri_158);
        calery_265 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_266 = (String) x.getText(R.string.food_Calorie_food_caleri_159);
        calery_267 = (String) x.getText(R.string.food_Calorie_food_caleri_5);
        calery_268 = (String) x.getText(R.string.food_Calorie_food_caleri_161);
        calery_269 = (String) x.getText(R.string.food_Calorie_food_caleri_162);
        calery_270 = (String) x.getText(R.string.food_Calorie_food_caleri_163);
        calery_271 = (String) x.getText(R.string.food_Calorie_food_caleri_164);
        calery_272 = (String) x.getText(R.string.food_Calorie_food_caleri_165);
        calery_273 = (String) x.getText(R.string.food_Calorie_food_caleri_12);
        calery_274 = (String) x.getText(R.string.food_Calorie_food_caleri_167);
        calery_275 = (String) x.getText(R.string.food_Calorie_food_caleri_168);
        calery_276 = (String) x.getText(R.string.food_Calorie_food_caleri_43);
        calery_277 = (String) x.getText(R.string.food_Calorie_food_caleri_42);
        calery_278 = (String) x.getText(R.string.food_Calorie_food_caleri_171);
        calery_279 = (String) x.getText(R.string.food_Calorie_food_caleri_172);
        calery_280 = (String) x.getText(R.string.food_Calorie_food_caleri_7);
        calery_281 = (String) x.getText(R.string.food_Calorie_food_caleri_12);
        calery_282 = (String) x.getText(R.string.food_Calorie_food_caleri_4);
        calery_283 = (String) x.getText(R.string.food_Calorie_food_caleri_176);

        list = new ArrayList<HashMap<String, String>>();

        list_c = new ArrayList<HashMap<String, String>>();
        list_b = new ArrayList<HashMap<String, String>>();


        // id food ha

        String fa = "fa";
        if (food_page_org.language == fa) {

            FIRST_COLUMN = "Column 3";
            SECOND_COLUMN = "Column 2";
            SECOND_COLUMN_2 = "Column 1";

        } else {

            FIRST_COLUMN = "Column 1";
            SECOND_COLUMN = "Column 2";
            SECOND_COLUMN_2 = "Column 3";

        }



        temp = new HashMap<String, String>();
        temp.put(FIRST_COLUMN, food_1);
        temp.put(SECOND_COLUMN, size_1);
        temp.put(SECOND_COLUMN_2, calery_1);
        list.add(temp);


        temp2 = new HashMap<String, String>();
        temp2.put(FIRST_COLUMN, food_2);
        temp2.put(SECOND_COLUMN, size_2);
        temp2.put(SECOND_COLUMN_2, calery_2);
        list.add(temp2);

        temp3 = new HashMap<String, String>();
        temp3.put(FIRST_COLUMN, food_3);
        temp3.put(SECOND_COLUMN, size_3);
        temp3.put(SECOND_COLUMN_2, calery_3);
        list.add(temp3);

        temp4 = new HashMap<String, String>();
        temp4.put(FIRST_COLUMN, food_4);
        temp4.put(SECOND_COLUMN, size_4);
        temp4.put(SECOND_COLUMN_2, calery_4);
        list.add(temp4);

        temp5 = new HashMap<String, String>();
        temp5.put(FIRST_COLUMN, food_5);
        temp5.put(SECOND_COLUMN, size_5);
        temp5.put(SECOND_COLUMN_2, calery_5);
        list.add(temp5);

        temp6 = new HashMap<String, String>();
        temp6.put(FIRST_COLUMN, food_6);
        temp6.put(SECOND_COLUMN, size_6);
        temp6.put(SECOND_COLUMN_2, calery_6);
        list.add(temp6);

        temp7 = new HashMap<String, String>();
        temp7.put(FIRST_COLUMN, food_7);
        temp7.put(SECOND_COLUMN, size_7);
        temp7.put(SECOND_COLUMN_2, calery_7);
        list.add(temp7);

        temp8 = new HashMap<String, String>();
        temp8.put(FIRST_COLUMN, food_8);
        temp8.put(SECOND_COLUMN, size_8);
        temp8.put(SECOND_COLUMN_2, calery_8);
        list.add(temp8);

        temp9 = new HashMap<String, String>();
        temp9.put(FIRST_COLUMN, food_9);
        temp9.put(SECOND_COLUMN, size_9);
        temp9.put(SECOND_COLUMN_2, calery_9);
        list.add(temp9);

        temp10 = new HashMap<String, String>();
        temp10.put(FIRST_COLUMN, food_10);
        temp10.put(SECOND_COLUMN, size_10);
        temp10.put(SECOND_COLUMN_2, calery_10);
        list.add(temp10);

        temp11 = new HashMap<String, String>();
        temp11.put(FIRST_COLUMN, food_11);
        temp11.put(SECOND_COLUMN, size_11);
        temp11.put(SECOND_COLUMN_2, calery_11);
        list.add(temp11);

        temp12 = new HashMap<String, String>();
        temp12.put(FIRST_COLUMN, food_12);
        temp12.put(SECOND_COLUMN, size_12);
        temp12.put(SECOND_COLUMN_2, calery_12);
        list.add(temp12);

        temp13 = new HashMap<String, String>();
        temp13.put(FIRST_COLUMN, food_13);
        temp13.put(SECOND_COLUMN, size_13);
        temp13.put(SECOND_COLUMN_2, calery_13);
        list.add(temp13);

        temp14 = new HashMap<String, String>();
        temp14.put(FIRST_COLUMN, food_14);
        temp14.put(SECOND_COLUMN, size_14);
        temp14.put(SECOND_COLUMN_2, calery_14);
        list.add(temp14);

        temp15 = new HashMap<String, String>();
        temp15.put(FIRST_COLUMN, food_15);
        temp15.put(SECOND_COLUMN, size_15);
        temp15.put(SECOND_COLUMN_2, calery_15);
        list.add(temp15);

        temp16 = new HashMap<String, String>();
        temp16.put(FIRST_COLUMN, food_16);
        temp16.put(SECOND_COLUMN, size_16);
        temp16.put(SECOND_COLUMN_2, calery_16);
        list.add(temp16);

        temp17 = new HashMap<String, String>();
        temp17.put(FIRST_COLUMN, food_17);
        temp17.put(SECOND_COLUMN, size_17);
        temp17.put(SECOND_COLUMN_2, calery_17);
        list.add(temp17);

        temp18 = new HashMap<String, String>();
        temp18.put(FIRST_COLUMN, food_18);
        temp18.put(SECOND_COLUMN, size_18);
        temp18.put(SECOND_COLUMN_2, calery_18);
        list.add(temp18);

        temp19 = new HashMap<String, String>();
        temp19.put(FIRST_COLUMN, food_19);
        temp19.put(SECOND_COLUMN, size_19);
        temp19.put(SECOND_COLUMN_2, calery_19);
        list.add(temp19);

        temp20 = new HashMap<String, String>();
        temp20.put(FIRST_COLUMN, food_20);
        temp20.put(SECOND_COLUMN, size_20);
        temp20.put(SECOND_COLUMN_2, calery_20);
        list.add(temp20);

        temp21 = new HashMap<String, String>();
        temp21.put(FIRST_COLUMN, food_21);
        temp21.put(SECOND_COLUMN, size_21);
        temp21.put(SECOND_COLUMN_2, calery_21);
        list.add(temp21);

        temp22 = new HashMap<String, String>();
        temp22.put(FIRST_COLUMN, food_22);
        temp22.put(SECOND_COLUMN, size_22);
        temp22.put(SECOND_COLUMN_2, calery_22);
        list.add(temp22);

        temp23 = new HashMap<String, String>();
        temp23.put(FIRST_COLUMN, food_23);
        temp23.put(SECOND_COLUMN, size_23);
        temp23.put(SECOND_COLUMN_2, calery_23);
        list.add(temp23);

        temp24 = new HashMap<String, String>();
        temp24.put(FIRST_COLUMN, food_24);
        temp24.put(SECOND_COLUMN, size_24);
        temp24.put(SECOND_COLUMN_2, calery_24);
        list.add(temp24);

        temp25 = new HashMap<String, String>();
        temp25.put(FIRST_COLUMN, food_25);
        temp25.put(SECOND_COLUMN, size_25);
        temp25.put(SECOND_COLUMN_2, calery_25);
        list.add(temp25);

        temp26 = new HashMap<String, String>();
        temp26.put(FIRST_COLUMN, food_26);
        temp26.put(SECOND_COLUMN, size_26);
        temp26.put(SECOND_COLUMN_2, calery_26);
        list.add(temp26);

        temp27 = new HashMap<String, String>();
        temp27.put(FIRST_COLUMN, food_27);
        temp27.put(SECOND_COLUMN, size_27);
        temp27.put(SECOND_COLUMN_2, calery_27);
        list.add(temp27);

        temp28 = new HashMap<String, String>();
        temp28.put(FIRST_COLUMN, food_28);
        temp28.put(SECOND_COLUMN, size_28);
        temp28.put(SECOND_COLUMN_2, calery_28);
        list.add(temp28);

        temp29 = new HashMap<String, String>();
        temp29.put(FIRST_COLUMN, food_29);
        temp29.put(SECOND_COLUMN, size_29);
        temp29.put(SECOND_COLUMN_2, calery_29);
        list.add(temp29);

        temp30 = new HashMap<String, String>();
        temp30.put(FIRST_COLUMN, food_30);
        temp30.put(SECOND_COLUMN, size_30);
        temp30.put(SECOND_COLUMN_2, calery_30);
        list.add(temp30);

        temp31 = new HashMap<String, String>();
        temp31.put(FIRST_COLUMN, food_31);
        temp31.put(SECOND_COLUMN, size_31);
        temp31.put(SECOND_COLUMN_2, calery_31);
        list.add(temp31);

        temp32 = new HashMap<String, String>();
        temp32.put(FIRST_COLUMN, food_32);
        temp32.put(SECOND_COLUMN, size_32);
        temp32.put(SECOND_COLUMN_2, calery_32);
        list.add(temp32);

        temp33 = new HashMap<String, String>();
        temp33.put(FIRST_COLUMN, food_33);
        temp33.put(SECOND_COLUMN, size_33);
        temp33.put(SECOND_COLUMN_2, calery_33);
        list.add(temp33);

        temp34 = new HashMap<String, String>();
        temp34.put(FIRST_COLUMN, food_34);
        temp34.put(SECOND_COLUMN, size_34);
        temp34.put(SECOND_COLUMN_2, calery_34);
        list.add(temp34);

        temp35 = new HashMap<String, String>();
        temp35.put(FIRST_COLUMN, food_35);
        temp35.put(SECOND_COLUMN, size_35);
        temp35.put(SECOND_COLUMN_2, calery_35);
        list.add(temp35);

        temp36 = new HashMap<String, String>();
        temp36.put(FIRST_COLUMN, food_36);
        temp36.put(SECOND_COLUMN, size_36);
        temp36.put(SECOND_COLUMN_2, calery_36);
        list.add(temp36);

        temp37 = new HashMap<String, String>();
        temp37.put(FIRST_COLUMN, food_37);
        temp37.put(SECOND_COLUMN, size_37);
        temp37.put(SECOND_COLUMN_2, calery_37);
        list.add(temp37);

        temp38 = new HashMap<String, String>();
        temp38.put(FIRST_COLUMN, food_38);
        temp38.put(SECOND_COLUMN, size_38);
        temp38.put(SECOND_COLUMN_2, calery_38);
        list.add(temp38);

        temp39 = new HashMap<String, String>();
        temp39.put(FIRST_COLUMN, food_39);
        temp39.put(SECOND_COLUMN, size_39);
        temp39.put(SECOND_COLUMN_2, calery_39);
        list.add(temp39);

        temp40 = new HashMap<String, String>();
        temp40.put(FIRST_COLUMN, food_40);
        temp40.put(SECOND_COLUMN, size_40);
        temp40.put(SECOND_COLUMN_2, calery_40);
        list.add(temp40);

        temp41 = new HashMap<String, String>();
        temp41.put(FIRST_COLUMN, food_41);
        temp41.put(SECOND_COLUMN, size_41);
        temp41.put(SECOND_COLUMN_2, calery_41);
        list.add(temp41);

        temp42 = new HashMap<String, String>();
        temp42.put(FIRST_COLUMN, food_42);
        temp42.put(SECOND_COLUMN, size_42);
        temp42.put(SECOND_COLUMN_2, calery_42);
        list.add(temp42);

        temp43 = new HashMap<String, String>();
        temp43.put(FIRST_COLUMN, food_43);
        temp43.put(SECOND_COLUMN, size_43);
        temp43.put(SECOND_COLUMN_2, calery_43);
        list.add(temp43);

        temp44 = new HashMap<String, String>();
        temp44.put(FIRST_COLUMN, food_44);
        temp44.put(SECOND_COLUMN, size_44);
        temp44.put(SECOND_COLUMN_2, calery_44);
        list.add(temp44);

        temp45 = new HashMap<String, String>();
        temp45.put(FIRST_COLUMN, food_45);
        temp45.put(SECOND_COLUMN, size_45);
        temp45.put(SECOND_COLUMN_2, calery_45);
        list.add(temp45);

        temp46 = new HashMap<String, String>();
        temp46.put(FIRST_COLUMN, food_46);
        temp46.put(SECOND_COLUMN, size_46);
        temp46.put(SECOND_COLUMN_2, calery_46);
        list.add(temp46);

        temp47 = new HashMap<String, String>();
        temp47.put(FIRST_COLUMN, food_47);
        temp47.put(SECOND_COLUMN, size_47);
        temp47.put(SECOND_COLUMN_2, calery_47);
        list.add(temp47);

        temp48 = new HashMap<String, String>();
        temp48.put(FIRST_COLUMN, food_48);
        temp48.put(SECOND_COLUMN, size_48);
        temp48.put(SECOND_COLUMN_2, calery_48);
        list.add(temp48);

        temp49 = new HashMap<String, String>();
        temp49.put(FIRST_COLUMN, food_49);
        temp49.put(SECOND_COLUMN, size_49);
        temp49.put(SECOND_COLUMN_2, calery_49);
        list.add(temp49);

        temp50 = new HashMap<String, String>();
        temp50.put(FIRST_COLUMN, food_50);
        temp50.put(SECOND_COLUMN, size_50);
        temp50.put(SECOND_COLUMN_2, calery_50);
        list.add(temp50);

        temp51 = new HashMap<String, String>();
        temp51.put(FIRST_COLUMN, food_51);
        temp51.put(SECOND_COLUMN, size_51);
        temp51.put(SECOND_COLUMN_2, calery_51);
        list.add(temp51);

        temp52 = new HashMap<String, String>();
        temp52.put(FIRST_COLUMN, food_52);
        temp52.put(SECOND_COLUMN, size_52);
        temp52.put(SECOND_COLUMN_2, calery_52);
        list.add(temp52);

        temp53 = new HashMap<String, String>();
        temp53.put(FIRST_COLUMN, food_53);
        temp53.put(SECOND_COLUMN, size_53);
        temp53.put(SECOND_COLUMN_2, calery_53);
        list.add(temp53);

        temp54 = new HashMap<String, String>();
        temp54.put(FIRST_COLUMN, food_54);
        temp54.put(SECOND_COLUMN, size_54);
        temp54.put(SECOND_COLUMN_2, calery_54);
        list.add(temp54);

        temp55 = new HashMap<String, String>();
        temp55.put(FIRST_COLUMN, food_55);
        temp55.put(SECOND_COLUMN, size_55);
        temp55.put(SECOND_COLUMN_2, calery_55);
        list.add(temp55);

        temp56 = new HashMap<String, String>();
        temp56.put(FIRST_COLUMN, food_56);
        temp56.put(SECOND_COLUMN, size_56);
        temp56.put(SECOND_COLUMN_2, calery_56);
        list.add(temp56);

        temp57 = new HashMap<String, String>();
        temp57.put(FIRST_COLUMN, food_57);
        temp57.put(SECOND_COLUMN, size_57);
        temp57.put(SECOND_COLUMN_2, calery_57);
        list.add(temp57);

        temp58 = new HashMap<String, String>();
        temp58.put(FIRST_COLUMN, food_58);
        temp58.put(SECOND_COLUMN, size_58);
        temp58.put(SECOND_COLUMN_2, calery_58);
        list.add(temp58);

        temp59 = new HashMap<String, String>();
        temp59.put(FIRST_COLUMN, food_59);
        temp59.put(SECOND_COLUMN, size_59);
        temp59.put(SECOND_COLUMN_2, calery_59);
        list.add(temp59);

        temp60 = new HashMap<String, String>();
        temp60.put(FIRST_COLUMN, food_60);
        temp60.put(SECOND_COLUMN, size_60);
        temp60.put(SECOND_COLUMN_2, calery_60);
        list.add(temp60);

        temp61 = new HashMap<String, String>();
        temp61.put(FIRST_COLUMN, food_61);
        temp61.put(SECOND_COLUMN, size_61);
        temp61.put(SECOND_COLUMN_2, calery_61);
        list.add(temp61);

        temp62 = new HashMap<String, String>();
        temp62.put(FIRST_COLUMN, food_62);
        temp62.put(SECOND_COLUMN, size_62);
        temp62.put(SECOND_COLUMN_2, calery_62);
        list.add(temp62);

        temp63 = new HashMap<String, String>();
        temp63.put(FIRST_COLUMN, food_63);
        temp63.put(SECOND_COLUMN, size_63);
        temp63.put(SECOND_COLUMN_2, calery_63);
        list.add(temp63);

        temp64 = new HashMap<String, String>();
        temp64.put(FIRST_COLUMN, food_64);
        temp64.put(SECOND_COLUMN, size_64);
        temp64.put(SECOND_COLUMN_2, calery_64);
        list.add(temp64);

        temp65 = new HashMap<String, String>();
        temp65.put(FIRST_COLUMN, food_65);
        temp65.put(SECOND_COLUMN, size_65);
        temp65.put(SECOND_COLUMN_2, calery_65);
        list.add(temp65);


        temp66 = new HashMap<String, String>();
        temp66.put(FIRST_COLUMN, food_66);
        temp66.put(SECOND_COLUMN, size_66);
        temp66.put(SECOND_COLUMN_2, calery_66);
        list.add(temp66);

        temp67 = new HashMap<String, String>();
        temp67.put(FIRST_COLUMN, food_67);
        temp67.put(SECOND_COLUMN, size_67);
        temp67.put(SECOND_COLUMN_2, calery_67);
        list.add(temp67);

        temp68 = new HashMap<String, String>();
        temp68.put(FIRST_COLUMN, food_68);
        temp68.put(SECOND_COLUMN, size_68);
        temp68.put(SECOND_COLUMN_2, calery_68);
        list.add(temp68);

        temp69 = new HashMap<String, String>();
        temp69.put(FIRST_COLUMN, food_69);
        temp69.put(SECOND_COLUMN, size_69);
        temp69.put(SECOND_COLUMN_2, calery_69);
        list.add(temp69);

        temp70 = new HashMap<String, String>();
        temp70.put(FIRST_COLUMN, food_70);
        temp70.put(SECOND_COLUMN, size_70);
        temp70.put(SECOND_COLUMN_2, calery_70);
        list.add(temp70);

        temp71 = new HashMap<String, String>();
        temp71.put(FIRST_COLUMN, food_71);
        temp71.put(SECOND_COLUMN, size_71);
        temp71.put(SECOND_COLUMN_2, calery_71);
        list.add(temp71);

        temp72 = new HashMap<String, String>();
        temp72.put(FIRST_COLUMN, food_72);
        temp72.put(SECOND_COLUMN, size_72);
        temp72.put(SECOND_COLUMN_2, calery_72);
        list.add(temp72);

        temp73 = new HashMap<String, String>();
        temp73.put(FIRST_COLUMN, food_73);
        temp73.put(SECOND_COLUMN, size_73);
        temp73.put(SECOND_COLUMN_2, calery_73);
        list.add(temp73);

        temp74 = new HashMap<String, String>();
        temp74.put(FIRST_COLUMN, food_74);
        temp74.put(SECOND_COLUMN, size_74);
        temp74.put(SECOND_COLUMN_2, calery_74);
        list.add(temp74);

        temp75 = new HashMap<String, String>();
        temp75.put(FIRST_COLUMN, food_75);
        temp75.put(SECOND_COLUMN, size_75);
        temp75.put(SECOND_COLUMN_2, calery_75);
        list.add(temp75);

        temp76 = new HashMap<String, String>();
        temp76.put(FIRST_COLUMN, food_76);
        temp76.put(SECOND_COLUMN, size_76);
        temp76.put(SECOND_COLUMN_2, calery_76);
        list.add(temp76);

        temp77 = new HashMap<String, String>();
        temp77.put(FIRST_COLUMN, food_77);
        temp77.put(SECOND_COLUMN, size_77);
        temp77.put(SECOND_COLUMN_2, calery_77);
        list.add(temp77);

        temp78 = new HashMap<String, String>();
        temp78.put(FIRST_COLUMN, food_78);
        temp78.put(SECOND_COLUMN, size_78);
        temp78.put(SECOND_COLUMN_2, calery_78);
        list.add(temp78);

        temp79 = new HashMap<String, String>();
        temp79.put(FIRST_COLUMN, food_79);
        temp79.put(SECOND_COLUMN, size_79);
        temp79.put(SECOND_COLUMN_2, calery_79);
        list.add(temp79);

        temp80 = new HashMap<String, String>();
        temp80.put(FIRST_COLUMN, food_80);
        temp80.put(SECOND_COLUMN, size_80);
        temp80.put(SECOND_COLUMN_2, calery_80);
        list.add(temp80);

        temp81 = new HashMap<String, String>();
        temp81.put(FIRST_COLUMN, food_81);
        temp81.put(SECOND_COLUMN, size_81);
        temp81.put(SECOND_COLUMN_2, calery_81);
        list.add(temp81);

        temp82 = new HashMap<String, String>();
        temp82.put(FIRST_COLUMN, food_82);
        temp82.put(SECOND_COLUMN, size_82);
        temp82.put(SECOND_COLUMN_2, calery_82);
        list.add(temp82);

        temp83 = new HashMap<String, String>();
        temp83.put(FIRST_COLUMN, food_83);
        temp83.put(SECOND_COLUMN, size_83);
        temp83.put(SECOND_COLUMN_2, calery_83);
        list.add(temp83);

        temp84 = new HashMap<String, String>();
        temp84.put(FIRST_COLUMN, food_84);
        temp84.put(SECOND_COLUMN, size_84);
        temp84.put(SECOND_COLUMN_2, calery_84);
        list.add(temp84);

        temp85 = new HashMap<String, String>();
        temp85.put(FIRST_COLUMN, food_85);
        temp85.put(SECOND_COLUMN, size_85);
        temp85.put(SECOND_COLUMN_2, calery_85);
        list.add(temp85);

        temp86 = new HashMap<String, String>();
        temp86.put(FIRST_COLUMN, food_86);
        temp86.put(SECOND_COLUMN, size_86);
        temp86.put(SECOND_COLUMN_2, calery_86);
        list.add(temp86);

        temp87 = new HashMap<String, String>();
        temp87.put(FIRST_COLUMN, food_87);
        temp87.put(SECOND_COLUMN, size_87);
        temp87.put(SECOND_COLUMN_2, calery_87);
        list.add(temp87);

        temp88 = new HashMap<String, String>();
        temp88.put(FIRST_COLUMN, food_88);
        temp88.put(SECOND_COLUMN, size_88);
        temp88.put(SECOND_COLUMN_2, calery_88);
        list.add(temp88);

        temp89 = new HashMap<String, String>();
        temp89.put(FIRST_COLUMN, food_89);
        temp89.put(SECOND_COLUMN, size_89);
        temp89.put(SECOND_COLUMN_2, calery_89);
        list.add(temp89);


        temp90 = new HashMap<String, String>();
        temp90.put(FIRST_COLUMN, food_90);
        temp90.put(SECOND_COLUMN, size_90);
        temp90.put(SECOND_COLUMN_2, calery_90);
        list.add(temp90);


        temp91 = new HashMap<String, String>();
        temp91.put(FIRST_COLUMN, food_91);
        temp91.put(SECOND_COLUMN, size_91);
        temp91.put(SECOND_COLUMN_2, calery_91);
        list.add(temp91);

        temp92 = new HashMap<String, String>();
        temp92.put(FIRST_COLUMN, food_92);
        temp92.put(SECOND_COLUMN, size_92);
        temp92.put(SECOND_COLUMN_2, calery_92);
        list.add(temp92);

        temp93 = new HashMap<String, String>();
        temp93.put(FIRST_COLUMN, food_93);
        temp93.put(SECOND_COLUMN, size_93);
        temp93.put(SECOND_COLUMN_2, calery_93);
        list.add(temp93);

        temp94 = new HashMap<String, String>();
        temp94.put(FIRST_COLUMN, food_94);
        temp94.put(SECOND_COLUMN, size_94);
        temp94.put(SECOND_COLUMN_2, calery_94);
        list.add(temp94);

        temp95 = new HashMap<String, String>();
        temp95.put(FIRST_COLUMN, food_95);
        temp95.put(SECOND_COLUMN, size_95);
        temp95.put(SECOND_COLUMN_2, calery_95);
        list.add(temp95);

        temp96 = new HashMap<String, String>();
        temp96.put(FIRST_COLUMN, food_96);
        temp96.put(SECOND_COLUMN, size_96);
        temp96.put(SECOND_COLUMN_2, calery_96);
        list.add(temp96);

        temp97 = new HashMap<String, String>();
        temp97.put(FIRST_COLUMN, food_97);
        temp97.put(SECOND_COLUMN, size_97);
        temp97.put(SECOND_COLUMN_2, calery_97);
        list.add(temp97);

        temp98 = new HashMap<String, String>();
        temp98.put(FIRST_COLUMN, food_98);
        temp98.put(SECOND_COLUMN, size_98);
        temp98.put(SECOND_COLUMN_2, calery_98);
        list.add(temp98);

        temp99 = new HashMap<String, String>();
        temp99.put(FIRST_COLUMN, food_99);
        temp99.put(SECOND_COLUMN, size_99);
        temp99.put(SECOND_COLUMN_2, calery_99);
        list.add(temp99);

        temp100 = new HashMap<String, String>();
        temp100.put(FIRST_COLUMN, food_100);
        temp100.put(SECOND_COLUMN, size_100);
        temp100.put(SECOND_COLUMN_2, calery_100);
        list.add(temp100);


        temp101 = new HashMap<String, String>();
        temp101.put(FIRST_COLUMN, food_101);
        temp101.put(SECOND_COLUMN, size_101);
        temp101.put(SECOND_COLUMN_2, calery_101);
        list.add(temp101);


        temp102 = new HashMap<String, String>();
        temp102.put(FIRST_COLUMN, food_102);
        temp102.put(SECOND_COLUMN, size_102);
        temp102.put(SECOND_COLUMN_2, calery_102);
        list.add(temp102);

        temp103 = new HashMap<String, String>();
        temp103.put(FIRST_COLUMN, food_103);
        temp103.put(SECOND_COLUMN, size_103);
        temp103.put(SECOND_COLUMN_2, calery_103);
        list.add(temp103);

        temp104 = new HashMap<String, String>();
        temp104.put(FIRST_COLUMN, food_104);
        temp104.put(SECOND_COLUMN, size_104);
        temp104.put(SECOND_COLUMN_2, calery_104);
        list.add(temp104);

        temp105 = new HashMap<String, String>();
        temp105.put(FIRST_COLUMN, food_105);
        temp105.put(SECOND_COLUMN, size_105);
        temp105.put(SECOND_COLUMN_2, calery_105);
        list.add(temp105);

        temp107 = new HashMap<String, String>();
        temp107.put(FIRST_COLUMN, food_107);
        temp107.put(SECOND_COLUMN, size_107);
        temp107.put(SECOND_COLUMN_2, calery_107);
        list.add(temp107);

        temp108 = new HashMap<String, String>();
        temp108.put(FIRST_COLUMN, food_108);
        temp108.put(SECOND_COLUMN, size_108);
        temp108.put(SECOND_COLUMN_2, calery_108);
        list.add(temp108);

        temp109 = new HashMap<String, String>();
        temp109.put(FIRST_COLUMN, food_109);
        temp109.put(SECOND_COLUMN, size_109);
        temp109.put(SECOND_COLUMN_2, calery_109);
        list.add(temp109);

        temp110 = new HashMap<String, String>();
        temp110.put(FIRST_COLUMN, food_110);
        temp110.put(SECOND_COLUMN, size_110);
        temp110.put(SECOND_COLUMN_2, calery_110);
        list.add(temp110);

        temp111 = new HashMap<String, String>();
        temp111.put(FIRST_COLUMN, food_111);
        temp111.put(SECOND_COLUMN, size_111);
        temp111.put(SECOND_COLUMN_2, calery_111);
        list.add(temp111);

        temp112 = new HashMap<String, String>();
        temp112.put(FIRST_COLUMN, food_112);
        temp112.put(SECOND_COLUMN, size_112);
        temp112.put(SECOND_COLUMN_2, calery_112);
        list.add(temp112);

        temp114 = new HashMap<String, String>();
        temp114.put(FIRST_COLUMN, food_114);
        temp114.put(SECOND_COLUMN, size_114);
        temp114.put(SECOND_COLUMN_2, calery_114);
        list.add(temp114);

        temp115 = new HashMap<String, String>();
        temp115.put(FIRST_COLUMN, food_115);
        temp115.put(SECOND_COLUMN, size_115);
        temp115.put(SECOND_COLUMN_2, calery_115);
        list.add(temp115);

        temp116 = new HashMap<String, String>();
        temp116.put(FIRST_COLUMN, food_116);
        temp116.put(SECOND_COLUMN, size_116);
        temp116.put(SECOND_COLUMN_2, calery_116);
        list.add(temp116);

        temp117 = new HashMap<String, String>();
        temp117.put(FIRST_COLUMN, food_117);
        temp117.put(SECOND_COLUMN, size_117);
        temp117.put(SECOND_COLUMN_2, calery_117);
        list.add(temp117);

        temp118 = new HashMap<String, String>();
        temp118.put(FIRST_COLUMN, food_118);
        temp118.put(SECOND_COLUMN, size_118);
        temp118.put(SECOND_COLUMN_2, calery_181);
        list.add(temp118);

        temp119 = new HashMap<String, String>();
        temp119.put(FIRST_COLUMN, food_119);
        temp119.put(SECOND_COLUMN, size_119);
        temp119.put(SECOND_COLUMN_2, calery_119);
        list.add(temp119);

        temp120 = new HashMap<String, String>();
        temp120.put(FIRST_COLUMN, food_120);
        temp120.put(SECOND_COLUMN, size_120);
        temp120.put(SECOND_COLUMN_2, calery_120);
        list.add(temp120);

        temp121 = new HashMap<String, String>();
        temp121.put(FIRST_COLUMN, food_121);
        temp121.put(SECOND_COLUMN, size_121);
        temp121.put(SECOND_COLUMN_2, calery_121);
        list.add(temp121);

        temp122 = new HashMap<String, String>();
        temp122.put(FIRST_COLUMN, food_122);
        temp122.put(SECOND_COLUMN, size_122);
        temp122.put(SECOND_COLUMN_2, calery_122);
        list.add(temp122);

        temp123 = new HashMap<String, String>();
        temp123.put(FIRST_COLUMN, food_123);
        temp123.put(SECOND_COLUMN, size_123);
        temp123.put(SECOND_COLUMN_2, calery_123);
        list.add(temp123);

        temp124 = new HashMap<String, String>();
        temp124.put(FIRST_COLUMN, food_124);
        temp124.put(SECOND_COLUMN, size_124);
        temp124.put(SECOND_COLUMN_2, calery_124);
        list.add(temp124);

        temp125 = new HashMap<String, String>();
        temp125.put(FIRST_COLUMN, food_125);
        temp125.put(SECOND_COLUMN, size_125);
        temp125.put(SECOND_COLUMN_2, calery_125);
        list.add(temp125);

        temp126 = new HashMap<String, String>();
        temp126.put(FIRST_COLUMN, food_126);
        temp126.put(SECOND_COLUMN, size_126);
        temp126.put(SECOND_COLUMN_2, calery_126);
        list.add(temp126);

        temp128 = new HashMap<String, String>();
        temp128.put(FIRST_COLUMN, food_128);
        temp128.put(SECOND_COLUMN, size_128);
        temp128.put(SECOND_COLUMN_2, calery_128);
        list.add(temp128);

        temp129 = new HashMap<String, String>();
        temp129.put(FIRST_COLUMN, food_129);
        temp129.put(SECOND_COLUMN, size_129);
        temp129.put(SECOND_COLUMN_2, calery_129);
        list.add(temp129);

        temp130 = new HashMap<String, String>();
        temp130.put(FIRST_COLUMN, food_130);
        temp130.put(SECOND_COLUMN, size_130);
        temp130.put(SECOND_COLUMN_2, calery_130);
        list.add(temp130);

        temp131 = new HashMap<String, String>();
        temp131.put(FIRST_COLUMN, food_131);
        temp131.put(SECOND_COLUMN, size_131);
        temp131.put(SECOND_COLUMN_2, calery_131);
        list.add(temp131);

        temp132 = new HashMap<String, String>();
        temp132.put(FIRST_COLUMN, food_132);
        temp132.put(SECOND_COLUMN, size_132);
        temp132.put(SECOND_COLUMN_2, calery_132);
        list.add(temp132);

        temp133 = new HashMap<String, String>();
        temp133.put(FIRST_COLUMN, food_133);
        temp133.put(SECOND_COLUMN, size_133);
        temp133.put(SECOND_COLUMN_2, calery_133);
        list.add(temp133);

        temp134 = new HashMap<String, String>();
        temp134.put(FIRST_COLUMN, food_134);
        temp134.put(SECOND_COLUMN, size_134);
        temp134.put(SECOND_COLUMN_2, calery_134);
        list.add(temp134);

        temp135 = new HashMap<String, String>();
        temp135.put(FIRST_COLUMN, food_135);
        temp135.put(SECOND_COLUMN, size_135);
        temp135.put(SECOND_COLUMN_2, calery_135);
        list.add(temp135);

        temp136 = new HashMap<String, String>();
        temp136.put(FIRST_COLUMN, food_136);
        temp136.put(SECOND_COLUMN, size_136);
        temp136.put(SECOND_COLUMN_2, calery_136);
        list.add(temp136);

        temp137 = new HashMap<String, String>();
        temp137.put(FIRST_COLUMN, food_137);
        temp137.put(SECOND_COLUMN, size_137);
        temp137.put(SECOND_COLUMN_2, calery_137);
        list.add(temp137);

        temp138 = new HashMap<String, String>();
        temp138.put(FIRST_COLUMN, food_138);
        temp138.put(SECOND_COLUMN, size_138);
        temp138.put(SECOND_COLUMN_2, calery_138);
        list.add(temp138);

        temp139 = new HashMap<String, String>();
        temp139.put(FIRST_COLUMN, food_139);
        temp139.put(SECOND_COLUMN, size_139);
        temp139.put(SECOND_COLUMN_2, calery_139);
        list.add(temp139);

        temp140 = new HashMap<String, String>();
        temp140.put(FIRST_COLUMN, food_140);
        temp140.put(SECOND_COLUMN, size_140);
        temp140.put(SECOND_COLUMN_2, calery_140);
        list.add(temp140);

        temp141 = new HashMap<String, String>();
        temp141.put(FIRST_COLUMN, food_141);
        temp141.put(SECOND_COLUMN, size_141);
        temp141.put(SECOND_COLUMN_2, calery_141);
        list.add(temp41);

        temp142 = new HashMap<String, String>();
        temp142.put(FIRST_COLUMN, food_142);
        temp142.put(SECOND_COLUMN, size_142);
        temp142.put(SECOND_COLUMN_2, calery_142);
        list.add(temp142);

        temp143 = new HashMap<String, String>();
        temp143.put(FIRST_COLUMN, food_143);
        temp143.put(SECOND_COLUMN, size_143);
        temp143.put(SECOND_COLUMN_2, calery_143);
        list.add(temp143);

        temp144 = new HashMap<String, String>();
        temp144.put(FIRST_COLUMN, food_144);
        temp144.put(SECOND_COLUMN, size_144);
        temp144.put(SECOND_COLUMN_2, calery_144);
        list.add(temp144);

        temp145 = new HashMap<String, String>();
        temp145.put(FIRST_COLUMN, food_145);
        temp145.put(SECOND_COLUMN, size_145);
        temp145.put(SECOND_COLUMN_2, calery_145);
        list.add(temp45);

        temp146 = new HashMap<String, String>();
        temp146.put(FIRST_COLUMN, food_146);
        temp146.put(SECOND_COLUMN, size_146);
        temp146.put(SECOND_COLUMN_2, calery_146);
        list.add(temp146);

        temp147 = new HashMap<String, String>();
        temp147.put(FIRST_COLUMN, food_147);
        temp147.put(SECOND_COLUMN, size_147);
        temp147.put(SECOND_COLUMN_2, calery_147);
        list.add(temp147);

        temp148 = new HashMap<String, String>();
        temp148.put(FIRST_COLUMN, food_148);
        temp148.put(SECOND_COLUMN, size_148);
        temp148.put(SECOND_COLUMN_2, calery_148);
        list.add(temp148);

        temp149 = new HashMap<String, String>();
        temp149.put(FIRST_COLUMN, food_149);
        temp149.put(SECOND_COLUMN, size_149);
        temp149.put(SECOND_COLUMN_2, calery_149);
        list.add(temp149);

        temp150 = new HashMap<String, String>();
        temp150.put(FIRST_COLUMN, food_150);
        temp150.put(SECOND_COLUMN, size_150);
        temp150.put(SECOND_COLUMN_2, calery_150);
        list.add(temp150);

        temp151 = new HashMap<String, String>();
        temp151.put(FIRST_COLUMN, food_151);
        temp151.put(SECOND_COLUMN, size_151);
        temp151.put(SECOND_COLUMN_2, calery_151);
        list.add(temp151);

        temp152 = new HashMap<String, String>();
        temp152.put(FIRST_COLUMN, food_152);
        temp152.put(SECOND_COLUMN, size_152);
        temp152.put(SECOND_COLUMN_2, calery_152);
        list.add(temp152);

        temp153 = new HashMap<String, String>();
        temp153.put(FIRST_COLUMN, food_153);
        temp153.put(SECOND_COLUMN, size_153);
        temp153.put(SECOND_COLUMN_2, calery_153);
        list.add(temp153);

        temp154 = new HashMap<String, String>();
        temp154.put(FIRST_COLUMN, food_154);
        temp154.put(SECOND_COLUMN, size_154);
        temp154.put(SECOND_COLUMN_2, calery_154);
        list.add(temp154);

        temp155 = new HashMap<String, String>();
        temp155.put(FIRST_COLUMN, food_155);
        temp155.put(SECOND_COLUMN, size_155);
        temp155.put(SECOND_COLUMN_2, calery_155);
        list.add(temp155);

        temp156 = new HashMap<String, String>();
        temp156.put(FIRST_COLUMN, food_156);
        temp156.put(SECOND_COLUMN, size_156);
        temp156.put(SECOND_COLUMN_2, calery_156);
        list.add(temp156);

        temp157 = new HashMap<String, String>();
        temp157.put(FIRST_COLUMN, food_157);
        temp157.put(SECOND_COLUMN, size_157);
        temp157.put(SECOND_COLUMN_2, calery_157);
        list.add(temp157);

        temp158 = new HashMap<String, String>();
        temp158.put(FIRST_COLUMN, food_158);
        temp158.put(SECOND_COLUMN, size_158);
        temp158.put(SECOND_COLUMN_2, calery_158);
        list.add(temp158);

        temp159 = new HashMap<String, String>();
        temp159.put(FIRST_COLUMN, food_159);
        temp159.put(SECOND_COLUMN, size_159);
        temp159.put(SECOND_COLUMN_2, calery_159);
        list.add(temp159);

        temp160 = new HashMap<String, String>();
        temp160.put(FIRST_COLUMN, food_160);
        temp160.put(SECOND_COLUMN, size_160);
        temp160.put(SECOND_COLUMN_2, calery_160);
        list.add(temp160);

        temp161 = new HashMap<String, String>();
        temp161.put(FIRST_COLUMN, food_161);
        temp161.put(SECOND_COLUMN, size_161);
        temp161.put(SECOND_COLUMN_2, calery_161);
        list.add(temp161);

        temp162 = new HashMap<String, String>();
        temp162.put(FIRST_COLUMN, food_162);
        temp162.put(SECOND_COLUMN, size_162);
        temp162.put(SECOND_COLUMN_2, calery_162);
        list.add(temp162);

        temp163 = new HashMap<String, String>();
        temp163.put(FIRST_COLUMN, food_163);
        temp163.put(SECOND_COLUMN, size_163);
        temp163.put(SECOND_COLUMN_2, calery_163);
        list.add(temp163);

        temp164 = new HashMap<String, String>();
        temp164.put(FIRST_COLUMN, food_164);
        temp164.put(SECOND_COLUMN, size_164);
        temp164.put(SECOND_COLUMN_2, calery_164);
        list.add(temp164);

        temp165 = new HashMap<String, String>();
        temp165.put(FIRST_COLUMN, food_165);
        temp165.put(SECOND_COLUMN, size_165);
        temp165.put(SECOND_COLUMN_2, calery_165);
        list.add(temp165);


        temp166 = new HashMap<String, String>();
        temp166.put(FIRST_COLUMN, food_166);
        temp166.put(SECOND_COLUMN, size_166);
        temp166.put(SECOND_COLUMN_2, calery_166);
        list.add(temp166);

        temp167 = new HashMap<String, String>();
        temp167.put(FIRST_COLUMN, food_167);
        temp167.put(SECOND_COLUMN, size_167);
        temp167.put(SECOND_COLUMN_2, calery_167);
        list.add(temp167);

        temp168 = new HashMap<String, String>();
        temp168.put(FIRST_COLUMN, food_168);
        temp168.put(SECOND_COLUMN, size_168);
        temp168.put(SECOND_COLUMN_2, calery_168);
        list.add(temp168);

        temp169 = new HashMap<String, String>();
        temp169.put(FIRST_COLUMN, food_169);
        temp169.put(SECOND_COLUMN, size_169);
        temp169.put(SECOND_COLUMN_2, calery_169);
        list.add(temp169);

        temp171 = new HashMap<String, String>();
        temp171.put(FIRST_COLUMN, food_171);
        temp171.put(SECOND_COLUMN, size_171);
        temp171.put(SECOND_COLUMN_2, calery_171);
        list.add(temp171);

        temp172 = new HashMap<String, String>();
        temp172.put(FIRST_COLUMN, food_172);
        temp172.put(SECOND_COLUMN, size_172);
        temp172.put(SECOND_COLUMN_2, calery_172);
        list.add(temp172);

        temp173 = new HashMap<String, String>();
        temp173.put(FIRST_COLUMN, food_173);
        temp173.put(SECOND_COLUMN, size_173);
        temp173.put(SECOND_COLUMN_2, calery_173);
        list.add(temp173);

        temp174 = new HashMap<String, String>();
        temp174.put(FIRST_COLUMN, food_174);
        temp174.put(SECOND_COLUMN, size_174);
        temp174.put(SECOND_COLUMN_2, calery_174);
        list.add(temp174);

        temp175 = new HashMap<String, String>();
        temp175.put(FIRST_COLUMN, food_175);
        temp175.put(SECOND_COLUMN, size_175);
        temp175.put(SECOND_COLUMN_2, calery_175);
        list.add(temp175);
        temp176 = new HashMap<String, String>();
        temp176.put(FIRST_COLUMN, food_176);
        temp176.put(SECOND_COLUMN, size_176);
        temp176.put(SECOND_COLUMN_2, calery_176);
        list.add(temp176);

        temp177 = new HashMap<String, String>();
        temp177.put(FIRST_COLUMN, food_177);
        temp177.put(SECOND_COLUMN, size_177);
        temp177.put(SECOND_COLUMN_2, calery_177);
        list.add(temp177);

        temp178 = new HashMap<String, String>();
        temp178.put(FIRST_COLUMN, food_178);
        temp178.put(SECOND_COLUMN, size_178);
        temp178.put(SECOND_COLUMN_2, calery_178);
        list.add(temp178);

        temp179 = new HashMap<String, String>();
        temp179.put(FIRST_COLUMN, food_179);
        temp179.put(SECOND_COLUMN, size_179);
        temp179.put(SECOND_COLUMN_2, calery_179);
        list.add(temp179);

        temp180 = new HashMap<String, String>();
        temp180.put(FIRST_COLUMN, food_180);
        temp180.put(SECOND_COLUMN, size_180);
        temp180.put(SECOND_COLUMN_2, calery_180);
        list.add(temp180);

        temp181 = new HashMap<String, String>();
        temp181.put(FIRST_COLUMN, food_181);
        temp181.put(SECOND_COLUMN, size_181);
        temp181.put(SECOND_COLUMN_2, calery_181);
        list.add(temp181);

        temp182 = new HashMap<String, String>();
        temp182.put(FIRST_COLUMN, food_182);
        temp182.put(SECOND_COLUMN, size_182);
        temp182.put(SECOND_COLUMN_2, calery_182);
        list.add(temp182);

        temp183 = new HashMap<String, String>();
        temp183.put(FIRST_COLUMN, food_183);
        temp183.put(SECOND_COLUMN, size_183);
        temp183.put(SECOND_COLUMN_2, calery_183);
        list.add(temp183);

        temp184 = new HashMap<String, String>();
        temp184.put(FIRST_COLUMN, food_184);
        temp184.put(SECOND_COLUMN, size_184);
        temp184.put(SECOND_COLUMN_2, calery_184);
        list.add(temp184);

        temp185 = new HashMap<String, String>();
        temp185.put(FIRST_COLUMN, food_185);
        temp185.put(SECOND_COLUMN, size_185);
        temp185.put(SECOND_COLUMN_2, calery_185);
        list.add(temp185);

        temp186 = new HashMap<String, String>();
        temp186.put(FIRST_COLUMN, food_186);
        temp186.put(SECOND_COLUMN, size_186);
        temp186.put(SECOND_COLUMN_2, calery_186);
        list.add(temp186);

        temp187 = new HashMap<String, String>();
        temp187.put(FIRST_COLUMN, food_187);
        temp187.put(SECOND_COLUMN, size_187);
        temp187.put(SECOND_COLUMN_2, calery_187);
        list.add(temp187);

        temp188 = new HashMap<String, String>();
        temp188.put(FIRST_COLUMN, food_188);
        temp188.put(SECOND_COLUMN, size_188);
        temp188.put(SECOND_COLUMN_2, calery_188);
        list.add(temp188);

        temp189 = new HashMap<String, String>();
        temp189.put(FIRST_COLUMN, food_189);
        temp189.put(SECOND_COLUMN, size_189);
        temp189.put(SECOND_COLUMN_2, calery_189);
        list.add(temp189);

        temp190 = new HashMap<String, String>();
        temp190.put(FIRST_COLUMN, food_190);
        temp190.put(SECOND_COLUMN, size_190);
        temp190.put(SECOND_COLUMN_2, calery_190);
        list.add(temp190);

        temp191 = new HashMap<String, String>();
        temp191.put(FIRST_COLUMN, food_191);
        temp191.put(SECOND_COLUMN, size_191);
        temp191.put(SECOND_COLUMN_2, calery_191);
        list.add(temp191);

        temp192 = new HashMap<String, String>();
        temp192.put(FIRST_COLUMN, food_192);
        temp192.put(SECOND_COLUMN, size_192);
        temp192.put(SECOND_COLUMN_2, calery_192);
        list.add(temp192);

        temp193 = new HashMap<String, String>();
        temp193.put(FIRST_COLUMN, food_193);
        temp193.put(SECOND_COLUMN, size_193);
        temp193.put(SECOND_COLUMN_2, calery_193);
        list.add(temp193);

        temp194 = new HashMap<String, String>();
        temp194.put(FIRST_COLUMN, food_194);
        temp194.put(SECOND_COLUMN, size_194);
        temp194.put(SECOND_COLUMN_2, calery_194);
        list.add(temp194);

        temp195 = new HashMap<String, String>();
        temp195.put(FIRST_COLUMN, food_195);
        temp195.put(SECOND_COLUMN, size_195);
        temp195.put(SECOND_COLUMN_2, calery_195);
        list.add(temp195);

        temp196 = new HashMap<String, String>();
        temp196.put(FIRST_COLUMN, food_196);
        temp196.put(SECOND_COLUMN, size_196);
        temp196.put(SECOND_COLUMN_2, calery_196);
        list.add(temp196);

        temp197 = new HashMap<String, String>();
        temp197.put(FIRST_COLUMN, food_197);
        temp197.put(SECOND_COLUMN, size_197);
        temp197.put(SECOND_COLUMN_2, calery_197);
        list.add(temp197);

        temp198 = new HashMap<String, String>();
        temp198.put(FIRST_COLUMN, food_198);
        temp198.put(SECOND_COLUMN, size_198);
        temp198.put(SECOND_COLUMN_2, calery_198);
        list.add(temp198);

        temp199 = new HashMap<String, String>();
        temp199.put(FIRST_COLUMN, food_199);
        temp199.put(SECOND_COLUMN, size_199);
        temp199.put(SECOND_COLUMN_2, calery_199);
        list.add(temp199);

        temp200 = new HashMap<String, String>();
        temp200.put(FIRST_COLUMN, food_200);
        temp200.put(SECOND_COLUMN, size_200);
        temp200.put(SECOND_COLUMN_2, calery_200);
        list.add(temp200);

        temp201 = new HashMap<String, String>();
        temp201.put(FIRST_COLUMN, food_201);
        temp201.put(SECOND_COLUMN, size_201);
        temp201.put(SECOND_COLUMN_2, calery_201);
        list.add(temp201);

        temp202 = new HashMap<String, String>();
        temp202.put(FIRST_COLUMN, food_202);
        temp202.put(SECOND_COLUMN, size_202);
        temp202.put(SECOND_COLUMN_2, calery_202);
        list.add(temp202);

        temp203 = new HashMap<String, String>();
        temp203.put(FIRST_COLUMN, food_203);
        temp203.put(SECOND_COLUMN, size_203);
        temp203.put(SECOND_COLUMN_2, calery_203);
        list.add(temp203);

        temp204 = new HashMap<String, String>();
        temp204.put(FIRST_COLUMN, food_204);
        temp204.put(SECOND_COLUMN, size_204);
        temp204.put(SECOND_COLUMN_2, calery_204);
        list.add(temp204);

        temp205 = new HashMap<String, String>();
        temp205.put(FIRST_COLUMN, food_205);
        temp205.put(SECOND_COLUMN, size_205);
        temp205.put(SECOND_COLUMN_2, calery_205);
        list.add(temp205);

        temp206 = new HashMap<String, String>();
        temp206.put(FIRST_COLUMN, food_206);
        temp206.put(SECOND_COLUMN, size_206);
        temp206.put(SECOND_COLUMN_2, calery_206);
        list.add(temp206);

        temp207 = new HashMap<String, String>();
        temp207.put(FIRST_COLUMN, food_207);
        temp207.put(SECOND_COLUMN, size_207);
        temp207.put(SECOND_COLUMN_2, calery_207);
        list.add(temp207);

        temp208 = new HashMap<String, String>();
        temp208.put(FIRST_COLUMN, food_208);
        temp208.put(SECOND_COLUMN, size_208);
        temp208.put(SECOND_COLUMN_2, calery_208);
        list.add(temp208);

        temp209 = new HashMap<String, String>();
        temp209.put(FIRST_COLUMN, food_209);
        temp209.put(SECOND_COLUMN, size_209);
        temp209.put(SECOND_COLUMN_2, calery_209);
        list.add(temp209);

        temp210 = new HashMap<String, String>();
        temp210.put(FIRST_COLUMN, food_210);
        temp210.put(SECOND_COLUMN, size_210);
        temp210.put(SECOND_COLUMN_2, calery_210);
        list.add(temp210);

        temp212 = new HashMap<String, String>();
        temp212.put(FIRST_COLUMN, food_212);
        temp212.put(SECOND_COLUMN, size_212);
        temp212.put(SECOND_COLUMN_2, calery_212);
        list.add(temp212);

        temp213 = new HashMap<String, String>();
        temp213.put(FIRST_COLUMN, food_213);
        temp213.put(SECOND_COLUMN, size_213);
        temp213.put(SECOND_COLUMN_2, calery_213);
        list.add(temp213);

        temp214 = new HashMap<String, String>();
        temp214.put(FIRST_COLUMN, food_214);
        temp214.put(SECOND_COLUMN, size_214);
        temp214.put(SECOND_COLUMN_2, calery_214);
        list.add(temp214);

        temp215 = new HashMap<String, String>();
        temp215.put(FIRST_COLUMN, food_215);
        temp215.put(SECOND_COLUMN, size_215);
        temp215.put(SECOND_COLUMN_2, calery_215);
        list.add(temp215);

        temp216 = new HashMap<String, String>();
        temp216.put(FIRST_COLUMN, food_216);
        temp216.put(SECOND_COLUMN, size_216);
        temp216.put(SECOND_COLUMN_2, calery_216);
        list.add(temp216);

        temp217 = new HashMap<String, String>();
        temp217.put(FIRST_COLUMN, food_217);
        temp217.put(SECOND_COLUMN, size_217);
        temp217.put(SECOND_COLUMN_2, calery_217);
        list.add(temp217);

        temp218 = new HashMap<String, String>();
        temp218.put(FIRST_COLUMN, food_218);
        temp218.put(SECOND_COLUMN, size_218);
        temp218.put(SECOND_COLUMN_2, calery_218);
        list.add(temp218);

        temp219 = new HashMap<String, String>();
        temp219.put(FIRST_COLUMN, food_219);
        temp219.put(SECOND_COLUMN, size_219);
        temp219.put(SECOND_COLUMN_2, calery_219);
        list.add(temp219);

        temp221 = new HashMap<String, String>();
        temp221.put(FIRST_COLUMN, food_221);
        temp221.put(SECOND_COLUMN, size_221);
        temp221.put(SECOND_COLUMN_2, calery_221);
        list.add(temp221);

        temp222 = new HashMap<String, String>();
        temp222.put(FIRST_COLUMN, food_222);
        temp222.put(SECOND_COLUMN, size_222);
        temp222.put(SECOND_COLUMN_2, calery_222);
        list.add(temp222);

        temp223 = new HashMap<String, String>();
        temp223.put(FIRST_COLUMN, food_223);
        temp223.put(SECOND_COLUMN, size_223);
        temp223.put(SECOND_COLUMN_2, calery_223);
        list.add(temp223);

        temp224 = new HashMap<String, String>();
        temp224.put(FIRST_COLUMN, food_224);
        temp224.put(SECOND_COLUMN, size_224);
        temp224.put(SECOND_COLUMN_2, calery_224);
        list.add(temp224);

        temp225 = new HashMap<String, String>();
        temp225.put(FIRST_COLUMN, food_225);
        temp225.put(SECOND_COLUMN, size_225);
        temp225.put(SECOND_COLUMN_2, calery_225);
        list.add(temp225);

        temp226 = new HashMap<String, String>();
        temp226.put(FIRST_COLUMN, food_226);
        temp226.put(SECOND_COLUMN, size_226);
        temp226.put(SECOND_COLUMN_2, calery_226);
        list.add(temp226);

        temp227 = new HashMap<String, String>();
        temp227.put(FIRST_COLUMN, food_227);
        temp227.put(SECOND_COLUMN, size_227);
        temp227.put(SECOND_COLUMN_2, calery_227);
        list.add(temp227);

        temp228 = new HashMap<String, String>();
        temp228.put(FIRST_COLUMN, food_228);
        temp228.put(SECOND_COLUMN, size_228);
        temp228.put(SECOND_COLUMN_2, calery_228);
        list.add(temp228);

        temp229 = new HashMap<String, String>();
        temp229.put(FIRST_COLUMN, food_229);
        temp229.put(SECOND_COLUMN, size_229);
        temp229.put(SECOND_COLUMN_2, calery_229);
        list.add(temp229);

        temp230 = new HashMap<String, String>();
        temp230.put(FIRST_COLUMN, food_230);
        temp230.put(SECOND_COLUMN, size_230);
        temp230.put(SECOND_COLUMN_2, calery_230);
        list.add(temp230);

        temp231 = new HashMap<String, String>();
        temp231.put(FIRST_COLUMN, food_231);
        temp231.put(SECOND_COLUMN, size_231);
        temp231.put(SECOND_COLUMN_2, calery_231);
        list.add(temp231);

        temp232 = new HashMap<String, String>();
        temp232.put(FIRST_COLUMN, food_232);
        temp232.put(SECOND_COLUMN, size_232);
        temp232.put(SECOND_COLUMN_2, calery_232);
        list.add(temp232);

        temp233 = new HashMap<String, String>();
        temp233.put(FIRST_COLUMN, food_233);
        temp233.put(SECOND_COLUMN, size_233);
        temp233.put(SECOND_COLUMN_2, calery_233);
        list.add(temp233);

        temp234 = new HashMap<String, String>();
        temp234.put(FIRST_COLUMN, food_234);
        temp234.put(SECOND_COLUMN, size_234);
        temp234.put(SECOND_COLUMN_2, calery_234);
        list.add(temp234);

        temp235 = new HashMap<String, String>();
        temp235.put(FIRST_COLUMN, food_235);
        temp235.put(SECOND_COLUMN, size_235);
        temp235.put(SECOND_COLUMN_2, calery_235);
        list.add(temp235);

        temp236 = new HashMap<String, String>();
        temp236.put(FIRST_COLUMN, food_236);
        temp236.put(SECOND_COLUMN, size_236);
        temp236.put(SECOND_COLUMN_2, calery_236);
        list.add(temp236);

        temp237 = new HashMap<String, String>();
        temp237.put(FIRST_COLUMN, food_237);
        temp237.put(SECOND_COLUMN, size_237);
        temp237.put(SECOND_COLUMN_2, calery_237);
        list.add(temp237);

        temp238 = new HashMap<String, String>();
        temp238.put(FIRST_COLUMN, food_238);
        temp238.put(SECOND_COLUMN, size_238);
        temp238.put(SECOND_COLUMN_2, calery_238);
        list.add(temp238);

        temp240 = new HashMap<String, String>();
        temp240.put(FIRST_COLUMN, food_240);
        temp240.put(SECOND_COLUMN, size_240);
        temp240.put(SECOND_COLUMN_2, calery_240);
        list.add(temp240);

        temp241 = new HashMap<String, String>();
        temp241.put(FIRST_COLUMN, food_241);
        temp241.put(SECOND_COLUMN, size_241);
        temp241.put(SECOND_COLUMN_2, calery_241);
        list.add(temp241);
        temp242 = new HashMap<String, String>();
        temp242.put(FIRST_COLUMN, food_242);
        temp242.put(SECOND_COLUMN, size_242);
        temp242.put(SECOND_COLUMN_2, calery_242);
        list.add(temp242);

        temp243 = new HashMap<String, String>();
        temp243.put(FIRST_COLUMN, food_243);
        temp243.put(SECOND_COLUMN, size_243);
        temp243.put(SECOND_COLUMN_2, calery_243);
        list.add(temp243);

        temp244 = new HashMap<String, String>();
        temp244.put(FIRST_COLUMN, food_244);
        temp244.put(SECOND_COLUMN, size_244);
        temp244.put(SECOND_COLUMN_2, calery_244);
        list.add(temp244);

        temp245 = new HashMap<String, String>();
        temp245.put(FIRST_COLUMN, food_245);
        temp245.put(SECOND_COLUMN, size_245);
        temp245.put(SECOND_COLUMN_2, calery_245);
        list.add(temp245);

        temp246 = new HashMap<String, String>();
        temp246.put(FIRST_COLUMN, food_246);
        temp246.put(SECOND_COLUMN, size_246);
        temp246.put(SECOND_COLUMN_2, calery_246);
        list.add(temp246);

        temp247 = new HashMap<String, String>();
        temp247.put(FIRST_COLUMN, food_247);
        temp247.put(SECOND_COLUMN, size_247);
        temp247.put(SECOND_COLUMN_2, calery_247);
        list.add(temp247);

        temp248 = new HashMap<String, String>();
        temp248.put(FIRST_COLUMN, food_248);
        temp248.put(SECOND_COLUMN, size_248);
        temp248.put(SECOND_COLUMN_2, calery_248);
        list.add(temp248);

        temp249 = new HashMap<String, String>();
        temp249.put(FIRST_COLUMN, food_249);
        temp249.put(SECOND_COLUMN, size_249);
        temp249.put(SECOND_COLUMN_2, calery_249);
        list.add(temp249);

        temp250 = new HashMap<String, String>();
        temp250.put(FIRST_COLUMN, food_250);
        temp250.put(SECOND_COLUMN, size_250);
        temp250.put(SECOND_COLUMN_2, calery_250);
        list.add(temp250);

        temp251 = new HashMap<String, String>();
        temp251.put(FIRST_COLUMN, food_251);
        temp251.put(SECOND_COLUMN, size_251);
        temp251.put(SECOND_COLUMN_2, calery_251);
        list.add(temp251);

        temp252 = new HashMap<String, String>();
        temp252.put(FIRST_COLUMN, food_252);
        temp252.put(SECOND_COLUMN, size_252);
        temp252.put(SECOND_COLUMN_2, calery_252);
        list.add(temp252);

        temp253 = new HashMap<String, String>();
        temp253.put(FIRST_COLUMN, food_253);
        temp253.put(SECOND_COLUMN, size_253);
        temp253.put(SECOND_COLUMN_2, calery_253);
        list.add(temp253);

        temp254 = new HashMap<String, String>();
        temp254.put(FIRST_COLUMN, food_254);
        temp254.put(SECOND_COLUMN, size_254);
        temp254.put(SECOND_COLUMN_2, calery_254);
        list.add(temp254);

        temp255 = new HashMap<String, String>();
        temp255.put(FIRST_COLUMN, food_255);
        temp255.put(SECOND_COLUMN, size_255);
        temp255.put(SECOND_COLUMN_2, calery_255);
        list.add(temp255);

        temp256 = new HashMap<String, String>();
        temp256.put(FIRST_COLUMN, food_256);
        temp256.put(SECOND_COLUMN, size_256);
        temp256.put(SECOND_COLUMN_2, calery_256);
        list.add(temp256);

        temp257 = new HashMap<String, String>();
        temp257.put(FIRST_COLUMN, food_257);
        temp257.put(SECOND_COLUMN, size_257);
        temp257.put(SECOND_COLUMN_2, calery_257);
        list.add(temp257);

        temp258 = new HashMap<String, String>();
        temp258.put(FIRST_COLUMN, food_258);
        temp258.put(SECOND_COLUMN, size_258);
        temp258.put(SECOND_COLUMN_2, calery_258);
        list.add(temp258);

        temp259 = new HashMap<String, String>();
        temp259.put(FIRST_COLUMN, food_259);
        temp259.put(SECOND_COLUMN, size_259);
        temp259.put(SECOND_COLUMN_2, calery_259);
        list.add(temp259);

        temp260 = new HashMap<String, String>();
        temp260.put(FIRST_COLUMN, food_260);
        temp260.put(SECOND_COLUMN, size_260);
        temp260.put(SECOND_COLUMN_2, calery_260);
        list.add(temp260);

        temp261 = new HashMap<String, String>();
        temp261.put(FIRST_COLUMN, food_261);
        temp261.put(SECOND_COLUMN, size_261);
        temp261.put(SECOND_COLUMN_2, calery_261);
        list.add(temp261);

        temp262 = new HashMap<String, String>();
        temp262.put(FIRST_COLUMN, food_262);
        temp262.put(SECOND_COLUMN, size_262);
        temp262.put(SECOND_COLUMN_2, calery_262);
        list.add(temp262);

        temp263 = new HashMap<String, String>();
        temp263.put(FIRST_COLUMN, food_263);
        temp263.put(SECOND_COLUMN, size_263);
        temp263.put(SECOND_COLUMN_2, calery_263);
        list.add(temp263);

        temp264 = new HashMap<String, String>();
        temp264.put(FIRST_COLUMN, food_264);
        temp264.put(SECOND_COLUMN, size_264);
        temp264.put(SECOND_COLUMN_2, calery_264);
        list.add(temp264);

        temp265 = new HashMap<String, String>();
        temp265.put(FIRST_COLUMN, food_265);
        temp265.put(SECOND_COLUMN, size_265);
        temp265.put(SECOND_COLUMN_2, calery_265);
        list.add(temp265);

        temp266 = new HashMap<String, String>();
        temp266.put(FIRST_COLUMN, food_266);
        temp266.put(SECOND_COLUMN, size_266);
        temp266.put(SECOND_COLUMN_2, calery_266);
        list.add(temp266);

        temp267 = new HashMap<String, String>();
        temp267.put(FIRST_COLUMN, food_267);
        temp267.put(SECOND_COLUMN, size_267);
        temp267.put(SECOND_COLUMN_2, calery_267);
        list.add(temp267);

        temp268 = new HashMap<String, String>();
        temp268.put(FIRST_COLUMN, food_268);
        temp268.put(SECOND_COLUMN, size_268);
        temp268.put(SECOND_COLUMN_2, calery_268);
        list.add(temp268);

        temp269 = new HashMap<String, String>();
        temp269.put(FIRST_COLUMN, food_269);
        temp269.put(SECOND_COLUMN, size_269);
        temp269.put(SECOND_COLUMN_2, calery_269);
        list.add(temp269);

        temp270 = new HashMap<String, String>();
        temp270.put(FIRST_COLUMN, food_270);
        temp270.put(SECOND_COLUMN, size_270);
        temp270.put(SECOND_COLUMN_2, calery_270);
        list.add(temp270);

        temp271 = new HashMap<String, String>();
        temp271.put(FIRST_COLUMN, food_271);
        temp271.put(SECOND_COLUMN, size_271);
        temp271.put(SECOND_COLUMN_2, calery_271);
        list.add(temp271);

        temp272 = new HashMap<String, String>();
        temp272.put(FIRST_COLUMN, food_272);
        temp272.put(SECOND_COLUMN, size_272);
        temp272.put(SECOND_COLUMN_2, calery_272);
        list.add(temp272);

        temp273 = new HashMap<String, String>();
        temp273.put(FIRST_COLUMN, food_273);
        temp273.put(SECOND_COLUMN, size_273);
        temp273.put(SECOND_COLUMN_2, calery_273);
        list.add(temp273);

        temp274 = new HashMap<String, String>();
        temp274.put(FIRST_COLUMN, food_274);
        temp274.put(SECOND_COLUMN, size_274);
        temp274.put(SECOND_COLUMN_2, calery_274);
        list.add(temp274);

        temp275 = new HashMap<String, String>();
        temp275.put(FIRST_COLUMN, food_275);
        temp275.put(SECOND_COLUMN, size_275);
        temp275.put(SECOND_COLUMN_2, calery_275);
        list.add(temp275);

        temp276 = new HashMap<String, String>();
        temp276.put(FIRST_COLUMN, food_276);
        temp276.put(SECOND_COLUMN, size_276);
        temp276.put(SECOND_COLUMN_2, calery_276);
        list.add(temp276);

        temp277 = new HashMap<String, String>();
        temp277.put(FIRST_COLUMN, food_277);
        temp277.put(SECOND_COLUMN, size_277);
        temp277.put(SECOND_COLUMN_2, calery_277);
        list.add(temp277);

        temp278 = new HashMap<String, String>();
        temp278.put(FIRST_COLUMN, food_278);
        temp278.put(SECOND_COLUMN, size_278);
        temp278.put(SECOND_COLUMN_2, calery_278);
        list.add(temp278);

        temp279 = new HashMap<String, String>();
        temp279.put(FIRST_COLUMN, food_279);
        temp279.put(SECOND_COLUMN, size_279);
        temp279.put(SECOND_COLUMN_2, calery_279);
        list.add(temp279);

        temp280 = new HashMap<String, String>();
        temp280.put(FIRST_COLUMN, food_280);
        temp280.put(SECOND_COLUMN, size_280);
        temp280.put(SECOND_COLUMN_2, calery_280);
        list.add(temp280);

        temp281 = new HashMap<String, String>();
        temp281.put(FIRST_COLUMN, food_281);
        temp281.put(SECOND_COLUMN, size_281);
        temp281.put(SECOND_COLUMN_2, calery_281);
        list.add(temp281);

        temp282 = new HashMap<String, String>();
        temp282.put(FIRST_COLUMN, food_282);
        temp282.put(SECOND_COLUMN, size_282);
        temp282.put(SECOND_COLUMN_2, calery_282);
        list.add(temp282);

        temp283 = new HashMap<String, String>();
        temp283.put(FIRST_COLUMN, food_283);
        temp283.put(SECOND_COLUMN, size_283);
        temp283.put(SECOND_COLUMN_2, calery_283);
        list.add(temp283);


        Collections.sort(list, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> stringStringMap, Map<String, String> t1) {
                String nr1 = String.valueOf(stringStringMap.get(FIRST_COLUMN));
                String nr2 = String.valueOf(t1.get(FIRST_COLUMN));
                return nr1.compareTo(nr2);
            }
        });

        list_c.addAll(list);
        list_b.addAll(list);
        FirebaseCrash.log("log 3");

    }

}
