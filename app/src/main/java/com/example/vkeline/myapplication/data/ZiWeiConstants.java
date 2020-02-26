package com.example.vkeline.myapplication.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkeline on 2018/3/19.
 */
public class ZiWeiConstants {
    private Map<String,String> ziweishiergong=new HashMap<>();
    private Map<String,String> wuxingju=new HashMap<>();

    private Map<String,String> wuxingshu=new HashMap<>();

    String[][] ziweixin = {{"丑","辰","亥","午","酉"},{"寅","丑","辰","亥","午"},{"寅","寅","丑","辰","亥"},{"卯","巳","寅","丑","辰"},{"卯","寅","子","寅","丑"},{"辰","卯","巳","未","寅"},{"辰","午","寅","子","戌"},{"巳","卯","卯","巳","未"},{"巳","辰","丑","寅","子"},{"午","未","午","卯","巳"},{"午","辰","卯","申","寅"},{"未","巳","辰","丑","卯"},{"未","申","寅","午","亥"},{"申","巳","未","卯","申"},{"申","午","辰","辰","丑"},{"酉","酉","巳","酉","午"},{"酉","午","卯","寅","卯"},{"戌","未","申","未","辰"},{"戌","戌","巳","辰","子"},{"亥","未","午","巳","酉"},{"亥","申","辰","戌","寅"},{"子","亥","酉","卯","未"},{"子","申","午","申","辰"},{"丑","酉","未","巳","巳"},{"丑","子","巳","午","丑"},{"寅","酉","戌","亥","戌"},{"寅","戌","未","辰","卯"},{"卯","丑","申","酉","申"},{"卯","戌","午","午","巳"},{"辰","亥","亥","未","午"}};
    String[][] shisizhengxing = {{"紫薇","","破军","","天府|廉贞","太阴","贪狼","天同|巨门","天相|武曲","天梁|太阳","七杀","天机"},{"天机","紫薇|破军","","天府","太阴","廉贞|贪狼","巨门","天相","天梁|天同","七杀|武曲","太阳",""},{"破军","天机","紫薇|天府","太阴","贪狼","巨门","天相|廉贞","天梁","七杀","天同","武曲","太阳"},{"太阳","天府","天机|太阴","紫薇|贪狼","巨门","天相","天梁","七杀|廉贞","","","天同","破军|武曲"},{"天府|武曲","太阴|太阳","贪狼","巨门|天机","紫薇|天相","天梁","七杀","","廉贞","","破军","天同"},{"天同|太阴","贪狼|武曲","巨门|太阳","天相","天机|天梁","紫薇|七杀","","","","破军","","天府"},{"贪狼","天同|巨门","天相|武曲","天梁|太阳","七杀","天机","紫薇","","破军","","天府","太阴"},{"巨门","天相","天梁|天同","七杀|武曲","太阳","","天机","紫薇|破军","","天府","太阴","贪狼|廉贞"},{"天相|廉贞","天梁","七杀","天同","武曲","太阳","破军","天机","紫薇|天府","太阴","贪狼","巨门"},{"天梁","七杀|廉贞","","","天同","破军|武曲","太阳","天府","天机|太阴","紫薇|贪狼","巨门","天相"},{"七杀","","廉贞","","破军","天同","天府|武曲","太阴|太阳","贪狼","天机|巨门","紫薇|天相","天梁"},{"","","","廉贞|破军","","天府","天同|太阴","贪狼|武曲","巨门|太阳","天相","天梁|天机","紫薇|七杀"}};

    String[][] yuefenxingxiu = {{"","天姚","阴煞","","左辅","天巫","","","","天刑","右弼|天月",""},{"阴煞","","天姚","","","天月|左辅","","","天巫","右弼","天刑",""},{"","","","天姚","天月","","左辅","","右弼","","阴煞","天刑|天巫"},{"天刑","","天月|天巫","","天姚","","","左辅|右弼","阴煞","","",""},{"","天刑","","","","天姚|天巫","右弼|阴煞","天月","左辅","","",""},{"","","天刑","天月","阴煞","右弼","天姚","","天巫","左辅","",""},{"","","阴煞","天刑","右弼","","","天姚","","","左辅","天月|天月"},{"阴煞","","天巫","右弼","天刑","","","天月","天姚","","","左辅"},{"左辅","","右弼|天月","","","天刑|天巫","","","","天姚","阴煞",""},{"","左辅|右弼","","","","","天刑|天月","","阴煞|天巫","","天姚",""},{"右弼","","左辅","","","","阴煞","天刑","","","天月","天姚|天巫"},{"天姚","","天姚|天巫","左辅","阴煞","","","","天刑","","","右弼"}};

    String[][] nianzhixizhuxing = {{"","","孤辰|天马","红鸾","龙池|华盖","破碎|劫杀","天虚|天哭","大耗","蜚廉","天喜|天德|咸池","凤阁|寡宿|解神","","贪","铃"},{"","破碎|华盖","红鸾|孤辰|劫杀","","","天哭|龙池","大耗|咸池","天虚","天喜","凤阁|解神|蜚廉","天德|寡宿","天马","巨","相"},{"","红鸾|寡宿","","咸池","天哭","孤辰","龙池","天喜","天虚|凤阁|解神|天马","破碎|大耗","华盖|蜚廉","天德|劫杀","禄","梁"},{"天德|红鸾|咸池","寡宿","","天哭","","孤辰|破碎|天马|蜚廉","天喜","龙池|凤阁|华盖|解神","大耗|劫杀","天虚","","","曲","同"},{"","天德|寡宿|破碎","天哭|天马","","华盖","天喜|孤辰|劫杀","凤阁|解神|蜚廉","","龙池","咸池","天虚","红鸾","廉","昌"},{"","天哭|华盖","天德|劫杀","","天喜|寡宿","凤阁|解神","咸池","蜚廉","孤辰","龙池|破碎","红鸾|大耗","天虚|天马","武","机"},{"天虚|天哭","大耗","蜚廉","天喜|天德|咸池","凤阁|寡宿|解神","破碎","","","孤辰|天马","红鸾","龙池|华盖","劫杀","破","火"},{"大耗|咸池","天虚|破碎","天喜","凤阁|解神|蜚廉","天德|寡宿","天马","","华盖","红鸾|孤辰|劫杀","","","天哭|龙池","武","相"},{"龙池","天喜","天虚|凤阁|解神|天马","大耗","华盖|蜚廉","天德|劫杀","","红鸾|寡宿","","破碎|咸池","天哭","孤辰","廉","梁"},{"天喜","龙池|凤阁|华盖|解神","大耗|劫杀","天虚","","破碎","天德|红鸾|咸池","寡宿","","天哭","","天马|蜚廉","曲","同"},{"凤阁|解神|蜚廉","破碎","龙池","咸池","天虚","红鸾|大耗","","天德|寡宿","天哭|天马","","华盖","天喜|孤辰|劫杀","禄","昌"},{"咸池","蜚廉","孤辰","龙池","红鸾|大耗","天虚|天马","","天哭|华盖","天德|劫杀","破碎","天喜|寡宿","凤阁|解神","巨","机"}};

    String[][] sihuaxing = {{"廉贞","破军","武曲","太阳"},{"天机","天梁","紫微","太阴"},{"天同","天机","文昌","廉贞"},{"太阴","天同","天机","巨门"},{"贪狼","太阴","右弼","天机"},{"武曲","贪狼","天梁","文曲"},{"太阳","武曲","太阴","天同"},{"巨门","太阳","文曲","文昌"},{"天梁","紫微","左辅","武曲"},{"破军","巨门","太阴","贪狼"}};

    String[][] shizhixizhuxing = {{"","","封诰","","文曲","","台辅","","","","文昌","天空|地劫"},{"地劫","","","封诰","","文曲","","台辅","","文昌","天空",""},{"","地劫","","","封诰","","文曲","","文昌|台辅","天空","",""},{"","","地劫","","","封诰","","文昌|文曲","天空","台辅","",""},{"","","","地劫","","","文昌|封诰","天空","文曲","","台辅",""},{"","","","","地劫","文昌","天空","封诰","","文曲","","台辅"},{"台辅","","","","文昌","天空|地劫","","","封诰","","文曲",""},{"","台辅","","文昌","天空","","地劫","","","封诰","","文曲"},{"文曲","","文昌|台辅","天空","","","","地劫","","","封诰",""},{"","文昌|文曲","天空","台辅","","","","","地劫","","","封诰"},{"文昌|封诰","天空","文曲","","台辅","","","","","地劫","",""},{"天空","封诰","","文曲","","台辅","","","","","地劫","文昌"}};

    String[][] nianganxizhuxing = {{"","陀罗星|天魁星","禄存星","擎羊星","","","","天钺星|天官星","正空亡","天福星|副空亡","",""},{"天魁星","","陀罗星","禄存星","擎羊星|天官星","","副空亡","正空亡","天钺星|天福星","","",""},{"天福星","","","","陀罗星|正空亡","禄存星|天官星|副空亡","擎羊星","","","天钺星","","天魁星"},{"","","天官星|副空亡","正空亡","","陀罗星","禄存星","擎羊星","","天钺星","","天魁星|天福星"},{"正空亡","天魁星|副空亡","","天福星|天官星","陀罗星","禄存星","擎羊星","天钺星","","","",""},{"天魁星","","天福星","","","陀罗星","禄存星","擎羊星","天钺星|副空亡","天官星|副空亡","",""},{"","天魁星","","","","","天福星|正空亡","陀罗星|天钺星|副空亡","禄存星","擎羊星","","天官星"},{"","","天钺星","","副空亡","天福星|正空亡","天魁星","","陀罗星","禄存星|天官星","擎羊星",""},{"擎羊星","","正空亡","天魁星|副空亡","","天钺星","天福星","","","","陀罗星|天官星","禄存星"},{"禄存星|副空亡","擎羊星|正空亡","","天魁星","","天钺星|天福星","天官星","","","","","陀罗星"}};

    public ZiWeiConstants() {
        ziweishiergong.put("1","命宫");
        ziweishiergong.put("2","兄弟宫");
        ziweishiergong.put("3","夫妻宫");
        ziweishiergong.put("4","子女宫");
        ziweishiergong.put("5","财帛宫");
        ziweishiergong.put("6","疾厄宫");
        ziweishiergong.put("7","迁移宫");
        ziweishiergong.put("8","奴仆宫");
        ziweishiergong.put("9","官禄宫");
        ziweishiergong.put("10","田宅宫");
        ziweishiergong.put("11","福德宫");
        ziweishiergong.put("12","父母宫");


         /*宫支→
        宫干↓	子、丑	寅、卯	辰、巳	午、未	申、酉	戍、亥
        甲、乙  金四局	水二局	火六局	金四局	水二局	火六局
        丙、丁	水二局	火六局	土五局	水二局	火六局	土五局
        戊、己	火六局	土五局	木三局	火六局	土五局	木三局
        庚、辛	土五局	木三局	金四局	土五局	木三局	金四局
        壬、癸	木三局	金四局	水二局	木三局	金四局	水二局*/


        wuxingju.put("甲子","金四局");
        wuxingju.put("甲丑","金四局");
        wuxingju.put("甲寅","水二局");
        wuxingju.put("甲卯","水二局");
        wuxingju.put("甲辰","火六局");
        wuxingju.put("甲巳","火六局");
        wuxingju.put("甲午","金四局");
        wuxingju.put("甲未","金四局");
        wuxingju.put("甲申","水二局");
        wuxingju.put("甲酉","水二局");
        wuxingju.put("甲戌","火六局");
        wuxingju.put("甲亥","火六局");

        wuxingju.put("乙子","金四局");
        wuxingju.put("乙丑","金四局");
        wuxingju.put("乙寅","水二局");
        wuxingju.put("乙卯","水二局");
        wuxingju.put("乙辰","火六局");
        wuxingju.put("乙巳","火六局");
        wuxingju.put("乙午","金四局");
        wuxingju.put("乙未","金四局");
        wuxingju.put("乙申","水二局");
        wuxingju.put("乙酉","水二局");
        wuxingju.put("乙戌","火六局");
        wuxingju.put("乙亥","火六局");


        wuxingju.put("丙子","水二局");
        wuxingju.put("丙丑","水二局");
        wuxingju.put("丙寅","火六局");
        wuxingju.put("丙卯","火六局");
        wuxingju.put("丙辰","土五局");
        wuxingju.put("丙巳","土五局");
        wuxingju.put("丙午","水二局");
        wuxingju.put("丙未","水二局");
        wuxingju.put("丙申","火六局");
        wuxingju.put("丙酉","火六局");
        wuxingju.put("丙戌","土五局");
        wuxingju.put("丙亥","土五局");



        wuxingju.put("丁子","水二局");
        wuxingju.put("丁丑","水二局");
        wuxingju.put("丁寅","火六局");
        wuxingju.put("丁卯","火六局");
        wuxingju.put("丁辰","土五局");
        wuxingju.put("丁巳","土五局");
        wuxingju.put("丁午","水二局");
        wuxingju.put("丁未","水二局");
        wuxingju.put("丁申","火六局");
        wuxingju.put("丁酉","火六局");
        wuxingju.put("丁戌","土五局");
        wuxingju.put("丁亥","土五局");

        //戊、己	火六局	土五局	木三局	火六局	土五局	木三局


        wuxingju.put("戊子","火六局");
        wuxingju.put("戊丑","火六局");
        wuxingju.put("戊寅","土五局");
        wuxingju.put("戊卯","土五局");
        wuxingju.put("戊辰","木三局");
        wuxingju.put("戊巳","木三局");
        wuxingju.put("戊午","火六局");
        wuxingju.put("戊未","火六局");
        wuxingju.put("戊申","土五局");
        wuxingju.put("戊酉","土五局");
        wuxingju.put("戊戌","木三局");
        wuxingju.put("戊亥","木三局");



        wuxingju.put("己子","火六局");
        wuxingju.put("己丑","火六局");
        wuxingju.put("己寅","土五局");
        wuxingju.put("己卯","土五局");
        wuxingju.put("己辰","木三局");
        wuxingju.put("己巳","木三局");
        wuxingju.put("己午","火六局");
        wuxingju.put("己未","火六局");
        wuxingju.put("己申","土五局");
        wuxingju.put("己酉","土五局");
        wuxingju.put("己戌","木三局");
        wuxingju.put("己亥","木三局");

//        庚、辛	土五局	木三局	金四局	土五局	木三局	金四局

        wuxingju.put("庚子","土五局");
        wuxingju.put("庚丑","土五局");
        wuxingju.put("庚寅","木三局");
        wuxingju.put("庚卯","木三局");
        wuxingju.put("庚辰","金四局");
        wuxingju.put("庚巳","金四局");
        wuxingju.put("庚午","土五局");
        wuxingju.put("庚未","土五局");
        wuxingju.put("庚申","木三局");
        wuxingju.put("庚酉","木三局");
        wuxingju.put("庚戌","金四局");
        wuxingju.put("庚亥","金四局");


        wuxingju.put("辛子","土五局");
        wuxingju.put("辛丑","土五局");
        wuxingju.put("辛寅","木三局");
        wuxingju.put("辛卯","木三局");
        wuxingju.put("辛辰","金四局");
        wuxingju.put("辛巳","金四局");
        wuxingju.put("辛午","土五局");
        wuxingju.put("辛未","土五局");
        wuxingju.put("辛申","木三局");
        wuxingju.put("辛酉","木三局");
        wuxingju.put("辛戌","金四局");
        wuxingju.put("辛亥","金四局");

//壬、癸	木三局	金四局	水二局	木三局	金四局	水二局
        wuxingju.put("壬子","木三局");
        wuxingju.put("壬丑","木三局");
        wuxingju.put("壬寅","金四局");
        wuxingju.put("壬卯","金四局");
        wuxingju.put("壬辰","水二局");
        wuxingju.put("壬巳","水二局");
        wuxingju.put("壬午","木三局");
        wuxingju.put("壬未","木三局");
        wuxingju.put("壬申","金四局");
        wuxingju.put("壬酉","金四局");
        wuxingju.put("壬戌","水二局");
        wuxingju.put("壬亥","水二局");


        wuxingju.put("癸子","木三局");
        wuxingju.put("癸丑","木三局");
        wuxingju.put("癸寅","金四局");
        wuxingju.put("癸卯","金四局");
        wuxingju.put("癸辰","水二局");
        wuxingju.put("癸巳","水二局");
        wuxingju.put("癸午","木三局");
        wuxingju.put("癸未","木三局");
        wuxingju.put("癸申","金四局");
        wuxingju.put("癸酉","金四局");
        wuxingju.put("癸戌","水二局");
        wuxingju.put("癸亥","水二局");

        wuxingshu.put("0","水");
        wuxingshu.put("1","木");
        wuxingshu.put("2","金");
        wuxingshu.put("3","土");
        wuxingshu.put("4","火");

    }

    public Map<String, String> getWuxingshu() {
        return wuxingshu;
    }

    public void setWuxingshu(Map<String, String> wuxingshu) {
        this.wuxingshu = wuxingshu;
    }

    public Map<String, String> getWuxingju() {
        return wuxingju;
    }

    public void setWuxingju(Map<String, String> wuxingju) {
        this.wuxingju = wuxingju;
    }

    public Map<String, String> getZiweishiergong() {
        return ziweishiergong;
    }

    public void setZiweishiergong(Map<String, String> ziweishiergong) {
        this.ziweishiergong = ziweishiergong;
    }

    public String[][] getZiweixin() {
        return ziweixin;
    }

    public String[][] getShisizhengxing() {
        return shisizhengxing;
    }

    public void setShisizhengxing(String[][] shisizhengxing) {
        this.shisizhengxing = shisizhengxing;
    }

    public void setZiweixin(String[][] ziweixin) {
        this.ziweixin = ziweixin;
    }

    public String[][] getYuefenxingxiu() {
        return yuefenxingxiu;
    }

    public void setYuefenxingxiu(String[][] yuefenxingxiu) {
        this.yuefenxingxiu = yuefenxingxiu;
    }

    public String[][] getNianzhixizhuxing() {
        return nianzhixizhuxing;
    }

    public void setNianzhixizhuxing(String[][] nianzhixizhuxing) {
        this.nianzhixizhuxing = nianzhixizhuxing;
    }

    public String[][] getSihuaxing() {
        return sihuaxing;
    }

    public void setSihuaxing(String[][] sihuaxing) {
        this.sihuaxing = sihuaxing;
    }


    public String[][] getShizhixizhuxing() {
        return shizhixizhuxing;
    }

    public void setShizhixizhuxing(String[][] shizhixizhuxing) {
        this.shizhixizhuxing = shizhixizhuxing;
    }

    public String[][] getNianganxizhuxing() {
        return nianganxizhuxing;
    }

    public void setNianganxizhuxing(String[][] nianganxizhuxing) {
        this.nianganxizhuxing = nianganxizhuxing;
    }
}
