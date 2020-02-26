package com.example.vkeline.myapplication.data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vkeline on 2018/2/27.
 */
public class Liushihuajiazi {

    private Map<String,String> huajiazi=new HashMap<>();
    private Map<String,String> tiangan=new HashMap<>();
    private Map<String,String> dizhi=new HashMap<>();
    private Map<String,String> shidizhi=new HashMap<>();
    private Map<String,String> tianganwuxing=new HashMap<>();
    private Map<String,String> dizhiwuxing=new HashMap<>();
    private Map<String,String> shishen=new HashMap<>();

    private Map<String,String[]> dizhicanzhi=new HashMap<>();
    //食神所代表的事物
    private Map<String,String> shishendaibiao =new HashMap<>();

    //五行所代表的性格分析
    private Map<String,String> wuxingxinggefenxi =new HashMap<>();
    //十神性格的优缺点
    private Map<String,String> shishenxingge =new HashMap<>();
    //食神的事业分析
    private Map<String,String> shishenshiye =new HashMap<>();



    public Liushihuajiazi() {
        huajiazi.put("1","甲子");
        huajiazi.put("2","乙丑");
        huajiazi.put("3","丙寅");
        huajiazi.put("4","丁卯");
        huajiazi.put("5","戊辰");
        huajiazi.put("6","己巳");
        huajiazi.put("7","庚午");
        huajiazi.put("8","辛未");
        huajiazi.put("9","壬申");
        huajiazi.put("10","癸酉");
        huajiazi.put("11","甲戌");
        huajiazi.put("12","乙亥");
        huajiazi.put("13","丙子");
        huajiazi.put("14","丁丑");
        huajiazi.put("15","戊寅");
        huajiazi.put("16","己卯");
        huajiazi.put("17","庚辰");
        huajiazi.put("18","辛巳");
        huajiazi.put("19","壬午");
        huajiazi.put("20","癸未");
        huajiazi.put("21","甲申");
        huajiazi.put("22","乙酉");
        huajiazi.put("23","丙戌");
        huajiazi.put("24","丁亥");
        huajiazi.put("25","戊子");
        huajiazi.put("26","己丑");
        huajiazi.put("27","庚寅");
        huajiazi.put("28","辛卯");
        huajiazi.put("29","壬辰");
        huajiazi.put("30","癸巳");
        huajiazi.put("31","甲午");
        huajiazi.put("32","乙未");
        huajiazi.put("33","丙申");
        huajiazi.put("34","丁酉");
        huajiazi.put("35","戊戌");
        huajiazi.put("36","己亥");
        huajiazi.put("37","庚子");
        huajiazi.put("38","辛丑");
        huajiazi.put("39","壬寅");
        huajiazi.put("40","癸卯");
        huajiazi.put("41","甲辰");
        huajiazi.put("42","乙巳");
        huajiazi.put("43","丙午");
        huajiazi.put("44","丁未");
        huajiazi.put("45","戊申");
        huajiazi.put("46","己酉");
        huajiazi.put("47","庚戌");
        huajiazi.put("48","辛亥");
        huajiazi.put("49","壬子");
        huajiazi.put("50","癸丑");
        huajiazi.put("51","甲寅");
        huajiazi.put("52","乙卯");
        huajiazi.put("53","丙辰");
        huajiazi.put("54","丁巳");
        huajiazi.put("55","戊午");
        huajiazi.put("56","己未");
        huajiazi.put("57","庚申");
        huajiazi.put("58","辛酉");
        huajiazi.put("59","壬戌");
        huajiazi.put("60","癸亥");


        tiangan.put("1","甲");
        tiangan.put("2","乙");
        tiangan.put("3","丙");
        tiangan.put("4","丁");
        tiangan.put("5","戊");
        tiangan.put("6","己");
        tiangan.put("7","庚");
        tiangan.put("8","辛");
        tiangan.put("9","壬");
        tiangan.put("10","癸");

        dizhi.put("11","子");
        dizhi.put("12","丑");
        dizhi.put("1","寅");
        dizhi.put("2","卯");
        dizhi.put("3","辰");
        dizhi.put("4","巳");
        dizhi.put("5","午");
        dizhi.put("6","未");
        dizhi.put("7","申");
        dizhi.put("8","酉");
        dizhi.put("9","戌");
        dizhi.put("10","亥");

        shidizhi.put("1","子");
        shidizhi.put("2","丑");
        shidizhi.put("3","寅");
        shidizhi.put("4","卯");
        shidizhi.put("5","辰");
        shidizhi.put("6","巳");
        shidizhi.put("7","午");
        shidizhi.put("8","未");
        shidizhi.put("9","申");
        shidizhi.put("10","酉");
        shidizhi.put("11","戌");
        shidizhi.put("12","亥");

        tianganwuxing.put("甲","阳木");
        tianganwuxing.put("乙","阴木");
        tianganwuxing.put("丙","阳火");
        tianganwuxing.put("丁","阴火");
        tianganwuxing.put("戊","阳土");
        tianganwuxing.put("己","阴土");
        tianganwuxing.put("庚","阳金");
        tianganwuxing.put("辛","阴金");
        tianganwuxing.put("壬","阳水");
        tianganwuxing.put("癸","阴水");


        dizhiwuxing.put("子","阳水");
        dizhiwuxing.put("丑","阴土");
        dizhiwuxing.put("寅","阳木");
        dizhiwuxing.put("卯","阴水");
        dizhiwuxing.put("辰","阳土");
        dizhiwuxing.put("巳","阴火");
        dizhiwuxing.put("午","阳火");
        dizhiwuxing.put("未","阴土");
        dizhiwuxing.put("申","阳金");
        dizhiwuxing.put("酉","阴金");
        dizhiwuxing.put("戌","阳土");
        dizhiwuxing.put("亥","阴水");
        /***
         * 阳  金 木 水 火 土
         * 阴  金 木 水 火 土
         */

        shishen.put("阳金阴金","劫");
        shishen.put("阳金阴木","财");
        shishen.put("阳金阴水","伤");
        shishen.put("阳金阴火","官");
        shishen.put("阳金阴土","印");

        shishen.put("阳木阴金","官");
        shishen.put("阳木阴木","劫");
        shishen.put("阳木阴水","印");
        shishen.put("阳木阴火","伤");
        shishen.put("阳木阴土","财");

        shishen.put("阳水阴金","印");
        shishen.put("阳水阴木","伤");
        shishen.put("阳水阴水","劫");
        shishen.put("阳水阴火","财");
        shishen.put("阳水阴土","官");

        shishen.put("阳火阴金","财");
        shishen.put("阳火阴木","印");
        shishen.put("阳火阴水","官");
        shishen.put("阳火阴火","劫");
        shishen.put("阳火阴土","伤");

        shishen.put("阳土阴金","伤");
        shishen.put("阳土阴木","官");
        shishen.put("阳土阴水","财");
        shishen.put("阳土阴火","印");
        shishen.put("阳土阴土","劫");

        /***
         * 阴  金 木 水 火 土
         * 阳  金 木 水 火 土
         */
        shishen.put("阴金阳金","劫");
        shishen.put("阴金阳木","财");
        shishen.put("阴金阳水","伤");
        shishen.put("阴金阳火","官");
        shishen.put("阴金阳土","印");

        shishen.put("阴木阳金","官");
        shishen.put("阴木阳木","劫");
        shishen.put("阴木阳水","印");
        shishen.put("阴木阳火","伤");
        shishen.put("阴木阳土","财");

        shishen.put("阴水阳金","印");
        shishen.put("阴水阳木","伤");
        shishen.put("阴水阳水","劫");
        shishen.put("阴水阳火","财");
        shishen.put("阴水阳土","官");

        shishen.put("阴火阳金","财");
        shishen.put("阴火阳木","印");
        shishen.put("阴火阳水","官");
        shishen.put("阴火阳火","劫");
        shishen.put("阴火阳土","伤");

        shishen.put("阴土阳金","伤");
        shishen.put("阴土阳木","官");
        shishen.put("阴土阳水","财");
        shishen.put("阴土阳火","印");
        shishen.put("阴土阳土","劫");


        /***
         * 阳  金 木 水 火 土
         * 阳 金 木 水 火 土
         */
        shishen.put("阳金阳金","比");
        shishen.put("阳金阳木","才");
        shishen.put("阳金阳水","食");
        shishen.put("阳金阳火","杀");
        shishen.put("阳金阳土","枭");

        shishen.put("阳木阳金","杀");
        shishen.put("阳木阳木","比");
        shishen.put("阳木阳水","枭");
        shishen.put("阳木阳火","食");
        shishen.put("阳木阳土","才");

        shishen.put("阳水阳金","枭");
        shishen.put("阳水阳木","食");
        shishen.put("阳水阳水","比");
        shishen.put("阳水阳火","才");
        shishen.put("阳水阳土","杀");

        shishen.put("阳火阳金","才");
        shishen.put("阳火阳木","枭");
        shishen.put("阳火阳水","杀");
        shishen.put("阳火阳火","比");
        shishen.put("阳火阳土","食");

        shishen.put("阳土阳金","食");
        shishen.put("阳土阳木","杀");
        shishen.put("阳土阳水","才");
        shishen.put("阳土阳火","枭");
        shishen.put("阳土阳土","比");






        /***
         * 阴  金 木 水 火 土
         * 阴  金 木 水 火 土
         */

        shishen.put("阴金阴金","比");
        shishen.put("阴金阴木","才");
        shishen.put("阴金阴水","食");
        shishen.put("阴金阴火","杀");
        shishen.put("阴金阴土","枭");

        shishen.put("阴木阴金","杀");
        shishen.put("阴木阴木","比");
        shishen.put("阴木阴水","枭");
        shishen.put("阴木阴火","食");
        shishen.put("阴木阴土","才");

        shishen.put("阴水阴金","枭");
        shishen.put("阴水阴木","食");
        shishen.put("阴水阴水","比");
        shishen.put("阴水阴火","才");
        shishen.put("阴水阴土","杀");

        shishen.put("阴火阴金","才");
        shishen.put("阴火阴木","枭");
        shishen.put("阴火阴水","杀");
        shishen.put("阴火阴火","比");
        shishen.put("阴火阴土","食");

        shishen.put("阴土阴金","食");
        shishen.put("阴土阴木","杀");
        shishen.put("阴土阴水","才");
        shishen.put("阴土阴火","枭");
        shishen.put("阴土阴土","比");

        dizhicanzhi.put("子",new String[]{"癸"});
        dizhicanzhi.put("丑",new String[]{"己","癸","辛"});
        dizhicanzhi.put("寅",new String[]{"丙","甲","戊"});
        dizhicanzhi.put("卯",new String[]{"乙"});
        dizhicanzhi.put("辰",new String[]{"乙","戊","癸"});
        dizhicanzhi.put("巳",new String[]{"戊","丙","庚"});
        dizhicanzhi.put("午",new String[]{"丁","己"});
        dizhicanzhi.put("未",new String[]{"乙","己","丁"});
        dizhicanzhi.put("申",new String[]{"戊","庚","壬"});
        dizhicanzhi.put("酉",new String[]{"辛"});
        dizhicanzhi.put("戌",new String[]{"辛","戊","丁"});
        dizhicanzhi.put("亥",new String[]{"壬","甲"});


        shishendaibiao.put("弱比","比肩，为用，财运不错，感情运比较一般，但是竞争容易成功，兄的姐妹可以帮助，同时也可以得到同事或者朋友的帮助，化危机为转机，得到更大的成就。");
        shishendaibiao.put("强比","比肩，为忌，财运不佳，感情容易不稳定，不易存钱，容易被朋友，同事，兄弟姐妹所用，竞争压力比较大，并且不适合合伙做事情");

        shishendaibiao.put("弱劫","劫财，为用，为阳刃，合伙办事容易成功，竞争容易成功，财运不错，可以得他人的钱财");
        shishendaibiao.put("强劫","劫财，为忌，阳刃为忌神，运势不佳，容易出刀伤之类的事件，需要注意点");

        shishendaibiao.put("弱食","食神，为忌，食神为忌神，运势不佳，喜欢胡思乱想，想法比较多，但是做了容易失败，感情运不佳，容易吵架，严重者易分开");
        shishendaibiao.put("强食","食神，为用，食神为用，运势佳，容易有很好的想法，做了容易成功，但是不适合合伙做事");

        shishendaibiao.put("强伤","伤官，为用，伤官为用，运势佳，容易有很好的想法，做了容易成功，不适合太过自以为是，需要脚踏实地，但是不适合合伙做事");
        shishendaibiao.put("弱伤","伤官，为忌，伤官为忌，运势不佳，胡思乱想，想发财，但不要去做，以静制动比较好，做了容易成功");

        shishendaibiao.put("强财","正财，为用，正财为用，运势佳，财运不错，容易有收入，工作生意上面容易挣钱，但是不适合合伙做事");
        shishendaibiao.put("弱财","正财，为忌，正财为忌，运势不佳，钱财容易丢失，生意上面不景气，事业上面不容易得到重视");

        shishendaibiao.put("强才","偏才，为用，偏才为用，运势佳，财运不错，容易有意外是收入，可以考虑投资，和做偏业或者自己做生意，工作生意上面容易挣钱，但是不适合合伙做事");
        shishendaibiao.put("弱才","偏才，为忌，偏才为忌，运势不佳，钱财容易丢失，并且不是很时候做生意，生意难成，最好不要做偏业，比如说：赌博，投资，买股票等都不利");

        shishendaibiao.put("强官","正官，为用，正官为用，运势佳，财运不错，容易得到上司的重视，并且容易升职，有贵人帮助，从政官运更佳");
        shishendaibiao.put("弱官","正官，为忌，正官为忌，运势不佳，钱财容易丢失，并且不是很时候做生意，生意难成，最好不要做偏业，比如说：赌博，投资，买股票等都不利");

        shishendaibiao.put("强杀","七杀，为用，七杀为用，运势佳，男命容易生女孩，财运不错，容易得到上司的重视，并且容易升职，有贵人帮助，从政官运更佳");
        shishendaibiao.put("弱杀","七杀，为忌，七杀为忌，运势不佳，七杀忌为鬼，做事需要小心，小人多，口舌是非，官事不易成功");

        shishendaibiao.put("弱印","正印，为用，运势佳，有利学习，学业，可以自我学东西，母亲可以帮助你，长辈上司可以帮助你");
        shishendaibiao.put("强印","正印，为忌，运势不佳，不利学业，学习，母亲运势不佳，财运不是很好");

        shishendaibiao.put("弱枭","偏印，为用，运势佳，在偏业方面容易成功，同时比你大的人容易帮助你，有利学业偏业，学习等");
        shishendaibiao.put("强枭","偏印，为忌，运势不佳，不利学习，贵人少，做事容易有阻，感情容易受到父母不好的影响");


        wuxingxinggefenxi.put("金","有英勇豪杰，仗义疏财，讲究礼仪廉耻，性格好胜，刚愎自用的特点。金命人非常讲义气，重视名誉，自尊心很强，性格孤傲，不屈不躬，针锋相对，刚直易折。但命金浅薄者，感情脆弱，虽有义而有始无终。行动稳定，外表严肃，刚毅有决，内心热情；待人耿直，重情重义，办事认真，秉公执政；脾气古怪，固执保守，针锋相对，刚直易脆；体健神清，面方白晰，肤色黝黑，眉高眼深，鼻高耳仰。");
        wuxingxinggefenxi.put("木","有博爱和恻隐之心，质朴清高，骨络修长的特点。木命人主慈，心地善良好施舍。特别是木多木旺的人，性格倔强。如桑拓木（壬子、癸丑年）出生的人，性格顽强，意志坚定不移，颇有宁愿站着死，不愿跪着生之性格，若乙丑年属牛的人就更有股倔强的牛脾气。古人曰：仁慈敏厚，木成甲乙方，木盛则怀恻隐之心。木性柔软，性情随和，感情丰富，举止洒脱；心胸广阔，生活乐观，善交朋友，清高自信；外貌高大，体长洁白，风姿美貌，仪表俊雅；气宇轩昂，语音柔和，面色清白，口尖发美。");
        wuxingxinggefenxi.put("水","水命的人足智多谋，聪而好学，有谋略。好思索，好动。五行气足者，体必丰肥，但水命之人平生多波折，生活坎坷不平，尤如江水经历千辛万苦，才能流归海。水多水旺者，其性情反而急躁，易出祸端。水命人总给人一种漂浮不定，举止轻浮的印象。好动肯谈，行动敏捷，心机灵变；能刚能柔，软中有硬，以柔克刚，刚柔并济；性情聪明，临事果决，命占桃花，风流多情；外形矮小，面黑光彩，语言清合。");
        wuxingxinggefenxi.put("火","待人总是彬彬有礼，有谦让之风，神采奕奕，性急而聪明的特点。火命人主礼貌，讲礼节，对长辈尊重，对晚辈讲义气；外貌威仪凛冽，淳朴厚道，遇事急躁，总爱夸夸其谈，喋喋不休；特别火多火旺的人，更是性急如火，喜手舞足蹈，快人快语，不顾后果，直来直去，往往容易把事情弄坏，常属好心无好报的耿直人。性情刚烈，感情易动，性急如火，热心快急。待人耿直，善交朋友，分外热情，尊长爱幼；逢恶不怕，见善不欺，见义勇为，缺乏冷静；外貌瘦小，面尖下圆，印堂狭窄，鼻孔易露；说话太急，语音激昂，言语妄诞，有始无终。");
        wuxingxinggefenxi.put("土","：有言行一致，说一不二，忠孝至诚，严守信义，好敬神佛的特点。 土命人讲信用，说到做到，不虚伪，待人忠厚老实；土多土旺的人喜静，不爱动，因而容易失去良机；对人宽宏大量，有忍劲和耐力，做事总是坚持不懈，有始有终，同时为人质朴，勤劳节约，办事踏实肯干。性情温厚，感情纯朴，待人诚实，讲信守誉；不讲假话，谈吐谨慎，做事细心，胆小怕事；背圆腰阔，鼻大口方，面胖色黄。土多土旺之人显得笨拙，土少薄弱之人声音浑浊。");

        shishenxingge.put("比","代表兄弟姐妹，朋友、战友、同学、同辈中人。比肩有帮身的作用，身旺为忌则克父克妻。优点：自尊心强，与人不和，独断专行，刚愎自用，好施展权威，坚持己见，好发号施令，为人好强，要面子。不服输，敢做敢为，敢拼敢闯，好管闲事，轻财好友。有组织管理才能，特别关心自己的部下，或朋友，受到拥护。为人讲究，但有抗上心理，喜自由，不愿受管制，缺点:身旺夺财，大多夫妻不和，易有婚变之灾，如组合不好婚后易有色情之灾，古有天干一气格，为富贵之命。又有专旺格：曰木曲直、水润下、火炎上、金从革、土稼蔷。身旺有比肩：以官为用大贵。以食伤为用利文途，学业有成，文章振发。以财为用大富，但起伏大，不长久。");
        shishenxingge.put("劫","代表兄弟姐妹，朋友、战友、同学、同辈中人。优点： 热诚坦直, 坚韧志旺, 奋斗不屈，缺点：身旺有比劫，其人好吹牛说大话，好色、贪酒赌博成性。喜投机，但贪小失大，对钱财挥霍无度。为忌则薄情寡义，兄弟不睦男女婚姻不顺的明显标志，也是破财受拖累的标志。仁慈博爱者自会仁慈，是凶恶歹毒者自会凶恶，此谓;江山易改，秉性难移, 但易流于盲目, 缺乏理智, 反为蛮横冲动");
        shishenxingge.put("食","代表长寿之星、吃穿、衣禄、头脑、思想、投资、子女、是忠孝的标志。优点：为人宽宏大量、优游自主、多福多寿、心宽体胖，精神健旺不喜与人争，为人厚道，讲道德。有君子之风。富有审美及艺术欣赏力，缺点：食神太过贱命一条，头脑迟顿，口语不清，甚至痴呆、傻子，极易上当受骗。");
        shishenxingge.put("伤","代表人的口才好，能说会道，聪明伶俐，机智灵巧的特性。有外交家的天赋与风度。平生爱好广泛，有艺术才能，性格外向开朗、活泼、爱说爱笑，人有独立性，不依赖他人，有抗上心理，缺点：但有时爱空想，不切实际,爱与当官的做对，气量狭窄有冤必报。叛逆、难以管束，本人也不愿受约束，崇尚自由");
        shishenxingge.put("财","代表妻子、钱财、才华、房产、田园，父辈姑姑、叔伯。又代表名誉地位、信誉、富禄吉祥喜庆之事等。优点：为人正义，明辨是非，爱打抱不平，诚实，有责任心。礼貌热情，对家庭忠实，对妻子爱惜。缺点：其人性格温顺，深谋远虑，处处小心谨慎，有时胆小怕事。自我保护意识很强。太过者，虚伪狡诈，不值得信赖。为人不爱读书，好逸恶劳。吝啬贪婪，苟安且乐。");
        shishenxingge.put("才","代表示意外之横财，浮动资产、彩票、奖金、股票等外来之财。又代表父辈兄弟姐妹。偏才乃众人之财，宜露不宜藏。缺点：男性天干露财：慷慨热情，一掷千金，出手阔绰。女性天干露财：穿金戴银，(注：日主为金水木)易因酒色而薄情寡义。性格不分喜忌，为人豪爽大方，风流多情，女人缘极佳。颇具商业头脑，会赚会花，不吝惜钱财，出手大方。女性善于交际，富于人情味，懂得照顾、体贴人。爱打扮，温柔多情。");
        shishenxingge.put("官","代表名誉地位，权贵。护财神、礼法约束、官司口舌、丈夫、儿子女儿等。为人清高，廉洁公正、自尊心强、重视名誉、品行端正、心地善良、光明磊落、讲道德重礼节。处处受人尊敬，为人厚道，做事稳重，办事认真。如为忌神或太过，依七杀之性断必验。");
        shishenxingge.put("杀","表示暴力，权力刚强有威、胆量、聪明伶俐、偏夫情人、小人、男命子女等。七杀喜制伏为贵。书曰：七杀有制化为权，即言此。富有进取心，待人热情，办事果敢，有正义感和侠义精神疾恶如仇，性刚急暴如火。做事有魄力，但脾气古怪任性。为人争强好胜不服输，女命易在婚姻上出麻烦，有感情风波。点击长生十二宫的含义和具体用法。");
        shishenxingge.put("印","官府掌权人的印章，权力的象征。代表文化、修养、学识、教养。印为护身之神，为生母，有时也为父亲。具有慈悲心肠，富有浓厚的人情味，待人重情、重义。其人有大志，聪明多智慧，大智若愚、内涵不露。思考力丰富，有随机应变的才能。相貌体态丰满，平生富态安祥。一生体健少病，无大险。女命以印为用，嫁理想之丈夫。命中有印，平生好敬神佛。");
        shishenxingge.put("枭","性好夺食，称其为枭。相传枭是上古时一种猛禽，从不自己觅食，专夺别人现成的食物。偏印有制为好，枭神多易有色情之灾，车祸官非口舌、克子女等。本身易生暗疾。枭神人性格多变，疑心重不轻易信任别人，朋友多难知心。其人貌丑身矮小，胆怯心虚，凡事无成。克害六亲严重，小时克母，长大克妻。太过者，优柔寡断，不切实际，懒惰、爱睡觉、办事虎头蛇尾，没长性，有始无终。如为喜用则心宽体胖，为有福之人，其人口才好，善辩、有外交家的才能心狠、好交朋友，但又多为朋友牵连、陷害等。");




        shishenshiye.put("比","贵人相助成事者。比肩与劫财都代表机遇人缘。如果比劫为用旺而逢生，或比劫为忌弱而受制，表示为人豪爽，侠肝义胆，仗义疏财，很适合与别人合资合作，共同创业。比肩比较适合同性，而劫财则比较适合异性。如果再配有福星禄星，那更是高朋满堂，朋友众多了。");
        shishenshiye.put("劫","贵人相助成事者。比肩与劫财都代表机遇人缘。如果比劫为用旺而逢生，或比劫为忌弱而受制，表示为人豪爽，侠肝义胆，仗义疏财，很适合与别人合资合作，共同创业。比肩比较适合同性，而劫财则比较适合异性。如果再配有福星禄星，那更是高朋满堂，朋友众多了。");
        shishenshiye.put("食","适合接触文艺事业或演艺事业者。食神与伤官都代表财源或智慧。如果食伤为用旺而逢生，或食伤为忌弱而受制，表示具有非凡的创造和表演能力，可以从事发明创造、学术研究或演艺娱乐方面的工作，既可创作文艺作品，创造影视角色，当然也可以创收财富。伤官多主演艺，而食神多主财源。如果再配有太极、华盖、桃花等智星，那更是如虎添翼，往往一鸣惊人。");
        shishenshiye.put("伤","适合接触文艺事业或演艺事业者。食神与伤官都代表财源或智慧。如果食伤为用旺而逢生，或食伤为忌弱而受制，表示具有非凡的创造和表演能力，可以从事发明创造、学术研究或演艺娱乐方面的工作，既可创作文艺作品，创造影视角色，当然也可以创收财富。伤官多主演艺，而食神多主财源。如果再配有太极、华盖、桃花等智星，那更是如虎添翼，往往一鸣惊人。");
        shishenshiye.put("财","工薪人士或偏财至富者。正才与偏财都代表财富财运。如果财星为用旺而逢生，或财星为忌弱而受制，表示很有赚钱的天赋，生财有道，故可从事发财致富的事业，正才多主工薪或经营性收入，而偏财则多主外财或营业外收入。如果再配有财库或驿马，那更是富甲一方，财运亨通了。");
        shishenshiye.put("才","工薪人士或偏财至富者。正才与偏财都代表财富财运。如果财星为用旺而逢生，或财星为忌弱而受制，表示很有赚钱的天赋，生财有道，故可从事发财致富的事业，正才多主工薪或经营性收入，而偏财则多主外财或营业外收入。如果再配有财库或驿马，那更是富甲一方，财运亨通了。");
        shishenshiye.put("官","具备领导才能政府高官或商场奋斗者。正官与偏官都可以代表工作事业，而正官多主官运，偏官多主事业。如果正官为用而比较旺相，或正官为忌弱而受制的，表示具备领导才能，可以向官场发展，如果再配以天乙贵人，那便有上级赏识提拔，平步青云；如果偏官（七杀）为用较旺，或七杀为忌弱而受制的，表示具备管理才能，可以向商场发展，如果再配有天乙贵人，那就会有政府领导做事业的靠山。两者如果再带有羊刃、将星，均主个性、魄力与才能很强，可以独挡一面，称雄一方。");
        shishenshiye.put("杀","具备领导才能政府高官或商场奋斗者。正官与偏官都可以代表工作事业，而正官多主官运，偏官多主事业。如果正官为用而比较旺相，或正官为忌弱而受制的，表示具备领导才能，可以向官场发展，如果再配以天乙贵人，那便有上级赏识提拔，平步青云；如果偏官（七杀）为用较旺，或七杀为忌弱而受制的，表示具备管理才能，可以向商场发展，如果再配有天乙贵人，那就会有政府领导做事业的靠山。两者如果再带有羊刃、将星，均主个性、魄力与才能很强，可以独挡一面，称雄一方。");
        shishenshiye.put("印","擅长理工科或文史类工作者。正印与偏印（枭神）代表文化学识，又代表心地。如果印星为用旺而逢生，或为忌弱而受制，表示具有宽厚仁慈，可以从事文化教育类的工作。正印比较擅长理工科的，而偏印则比较擅长文史哲的，如果再配有学堂、词馆、文昌、国印桃花等文星，那更是锦上添花，相得益彰了。");
        shishenshiye.put("枭","擅长理工科或文史类工作者。正印与偏印（枭神）代表文化学识，又代表心地。如果印星为用旺而逢生，或为忌弱而受制，表示具有宽厚仁慈，可以从事文化教育类的工作。正印比较擅长理工科的，而偏印则比较擅长文史哲的，如果再配有学堂、词馆、文昌、国印桃花等文星，那更是锦上添花，相得益彰了。");

    }

    public Map<String, String> getHuajiazi() {
        return huajiazi;
    }

    public void setHuajiazi(Map<String, String> huajiazi) {
        this.huajiazi = huajiazi;
    }

    public Map<String, String> getTiangan() {
        return tiangan;
    }

    public void setTiangan(Map<String, String> tiangan) {
        this.tiangan = tiangan;
    }

    public Map<String, String> getDizhi() {
        return dizhi;
    }

    public void setDizhi(Map<String, String> dizhi) {
        this.dizhi = dizhi;
    }

    public Map<String, String> getShidizhi() {
        return shidizhi;
    }

    public void setShidizhi(Map<String, String> shidizhi) {
        this.shidizhi = shidizhi;
    }

    public Map<String, String> getTianganwuxing() {
        return tianganwuxing;
    }

    public void setTianganwuxing(Map<String, String> tianganwuxing) {
        this.tianganwuxing = tianganwuxing;
    }

    public Map<String, String> getDizhiwuxing() {
        return dizhiwuxing;
    }

    public void setDizhiwuxing(Map<String, String> dizhiwuxing) {
        this.dizhiwuxing = dizhiwuxing;
    }

    public Map<String, String> getShishen() {
        return shishen;
    }

    public void setShishen(Map<String, String> shishen) {
        this.shishen = shishen;
    }

    public Map<String, String[]> getDizhicanzhi() {
        return dizhicanzhi;
    }

    public void setDizhicanzhi(Map<String, String[]> dizhicanzhi) {
        this.dizhicanzhi = dizhicanzhi;
    }


    public Map<String, String> getShishendaibiao() {
        return shishendaibiao;
    }

    public void setShishendaibiao(Map<String, String> shishendaibiao) {
        this.shishendaibiao = shishendaibiao;
    }

    public Map<String, String> getWuxingxinggefenxi() {
        return wuxingxinggefenxi;
    }

    public void setWuxingxinggefenxi(Map<String, String> wuxingxinggefenxi) {
        this.wuxingxinggefenxi = wuxingxinggefenxi;
    }

    public Map<String, String> getShishenxingge() {
        return shishenxingge;
    }

    public void setShishenxingge(Map<String, String> shishenxingge) {
        this.shishenxingge = shishenxingge;
    }

    public Map<String, String> getShishenshiye() {
        return shishenshiye;
    }

    public void setShishenshiye(Map<String, String> shishenshiye) {
        this.shishenshiye = shishenshiye;
    }
}
