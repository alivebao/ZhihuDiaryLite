package com.miao.administrator.diarycontentresolver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String strDiaryContent = "{\"body\":\"<div class=\\\"main-wrap content-wrap\\\">\\n<div class=\\\"headline\\\">\\n\\n<div class=\\\"img-place-holder\\\"><\\/div>\\n\\n\\n\\n<\\/div>\\n\\n<div class=\\\"content-inner\\\">\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">深海生物为什么可以承受如此大的压力？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/da8e974dc_is.jpg\\\">\\n<span class=\\\"author\\\">知乎用户<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p>从海平面开始，深度每增加 10 米，压强增加一个大气压。全球大洋平均深度 4000 米，而在这个深度，压强是 400atm, 什么感觉呢，大约是两只大象站在你的大拇脚趾头上。<\\/p>\\r\\n<p>前面答案大多提到了体内外压力差相等，但是否这就抵消了深海如此大的压强呢？<\\/p>\\r\\n<p>海洋学家出海时很爱干这么一件事：拿一个泡沫杯，绑在采样或者探测仪器上，放入深海，取上来以后，会收获一个&hellip;&hellip;完美缩小的泡沫杯。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/70\\/a5f71e6ebc18c7a58fe09387d6f448d3_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>这个杯子放在任何一个深度，内外压强都是相等的，但它进过高压的洗礼，还是 一夜回到解放前。所以在压强面前，只要有固体形态，有压缩性，都会或多或少受到影响。对于生物体来说，高压强最直接的作用是减少分子的体积而导致的机体结构变化。作为一个分子而言，这压强是十足的作用在其身上的。生物体都是由一个个分子构成的，其主要构成单位蛋白质，以及各种脂膜的结构和功能都相应的发生了一些变化，以适应深海的压强。<\\/p>\\r\\n<p>首先说说蛋白质。既然压强的直接作用是导致体积的变化，深海生物蛋白质的适应也是体现在体积变化。蛋白质不是刚性结构，意味着它可以通过三级或四级结构转化而进行『构象变换』。 此外，蛋白质亚单位组合，辅因子和酶的相互作用，催化反应，都伴随着蛋白质的结构 \\/ 体积变化。深海生物的适应进化便是减少这种体积变化。（粗暴的可以这么理解：你不是要缩小我的体积（变化）吗，我提前自己变到最小，你能拿我怎么办。）然而这种变化不是没有代价的，蛋白质的结构与其功能是息息相关的。所以通常情况下，深海生物的蛋白酶催化效率要远小于同种类的浅海酶。<\\/p>\\r\\n<p>再来看生物膜。生物膜的主要成分是脂类，其压缩性是大于水的，所以在高压强下，也会发生一系列的结构变化。前面 @苏澄宇已经提到了细胞膜的流动性变化。膜中的脂类为适应环境条件而调整其流动性的机制叫均黏调试（Homeoviscous Adaptation）。此机制在高压和低温下有相同的反应。压强升高或者温度降低都会降低膜的流动性。大约深度每增加 100 米的作用和温度降低 0.13-0.21 摄氏度相同。深海生物为了抵抗这种作用，进化出了一些机制来增加膜的流动性，以保障正常的生理需要。<\\/p>\\r\\n<p>膜的主要结构是两层磷脂夹杂着一些蛋白质<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic2.zhimg.com\\/70\\/c00c8ea31b85848d01efa2802089ed09_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>磷脂的排列结构决定了膜的流动性<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/70\\/89e8e0cc6c636d46436b116c0b8f6010_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>如上图所示，两条烃基链分的越开，膜的流动性越强。所以深海生物的适应就旨在保持磷脂分子抬头挺胸圆规腿，而且可以尽可能的保持这种形态。主要的途径有两种：<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic3.zhimg.com\\/70\\/2383ac72e76b35ee28fba950f8fce13e_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>1. PE （Phosphatidylethanolamine） 和 PC（Phosphatidylcholine） 是两种不同的磷脂分子，其最大的区别，你们也看见了，一个小头，一个大头，其带来的结构变化也是一目了然。所以多使用 PE，就是深海生物的一种进化适应。<\\/p>\\r\\n<p>2. 接下来要谈的就是大家都熟悉的饱和和不饱和脂肪酸。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/70\\/af9ce79d062ae56fc0dcde8be3dd49bf_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>饱和和不饱和脂肪酸差别就在烃基上的那个双键。双键就意味着平面结构（想象一下大闸蟹），导致拐腿那个姿态就变不了了。所以不饱和键的存在，增加了膜的流动性。<\\/p>\\r\\n<p>之前提到低温和高压对膜的适应进化有相似的作用，而全球大洋平均温度是 4 摄氏度，这也就是为什么海洋生物（深海以及冷水）多富含不饱和脂肪酸。<\\/p>\\r\\n<p>总的来说，深海生物对抗高压的方法就是减小自身的压缩性，从而把压强的作用减到最小。<\\/p>\\r\\n<hr \\/>\\r\\n<p>更多讨论，查看 知乎圆桌 &middot;&nbsp;<a class=\\\"internal\\\" href=\\\"http:\\/\\/www.zhihu.com\\/roundtable\\/oceanography\\\">潜入蔚蓝<\\/a><\\/p>\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/20257982\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n<\\/div>\\n<\\/div>\",\"image_source\":\"Takuma Kimura \\/ CC BY-SA\",\"title\":\"每天承受那么大压力，它们依然活得好好的\",\"image\":\"http:\\/\\/pic1.zhimg.com\\/4f48e2673fc129758f9f19eab85348b4.jpg\",\"share_url\":\"http:\\/\\/daily.zhihu.com\\/story\\/7363862\",\"js\":[\"http:\\/\\/news.at.zhihu.com\\/js\\/story.js?v=\\/js\\/story.js\"],\"ga_prefix\":\"102910\",\"type\":0,\"id\":7363862,\"css\":[\"http:\\/\\/news.at.zhihu.com\\/css\\/news_qa.auto.css?v=77778\"]}";
    private String strHTMLData = "<div class=\\\"main-wrap content-wrap\\\">\\n<div class=\\\"headline\\\">\\n\\n<div class=\\\"img-place-holder\\\"><\\/div>\\n\\n\\n\\n<\\/div>\\n\\n<div class=\\\"content-inner\\\">\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">深海生物为什么可以承受如此大的压力？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/da8e974dc_is.jpg\\\">\\n<span class=\\\"author\\\">知乎用户<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p>从海平面开始，深度每增加 10 米，压强增加一个大气压。全球大洋平均深度 4000 米，而在这个深度，压强是 400atm, 什么感觉呢，大约是两只大象站在你的大拇脚趾头上。<\\/p>\\r\\n<p>前面答案大多提到了体内外压力差相等，但是否这就抵消了深海如此大的压强呢？<\\/p>\\r\\n<p>海洋学家出海时很爱干这么一件事：拿一个泡沫杯，绑在采样或者探测仪器上，放入深海，取上来以后，会收获一个&hellip;&hellip;完美缩小的泡沫杯。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/70\\/a5f71e6ebc18c7a58fe09387d6f448d3_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>这个杯子放在任何一个深度，内外压强都是相等的，但它进过高压的洗礼，还是 一夜回到解放前。所以在压强面前，只要有固体形态，有压缩性，都会或多或少受到影响。对于生物体来说，高压强最直接的作用是减少分子的体积而导致的机体结构变化。作为一个分子而言，这压强是十足的作用在其身上的。生物体都是由一个个分子构成的，其主要构成单位蛋白质，以及各种脂膜的结构和功能都相应的发生了一些变化，以适应深海的压强。<\\/p>\\r\\n<p>首先说说蛋白质。既然压强的直接作用是导致体积的变化，深海生物蛋白质的适应也是体现在体积变化。蛋白质不是刚性结构，意味着它可以通过三级或四级结构转化而进行『构象变换』。 此外，蛋白质亚单位组合，辅因子和酶的相互作用，催化反应，都伴随着蛋白质的结构 \\/ 体积变化。深海生物的适应进化便是减少这种体积变化。（粗暴的可以这么理解：你不是要缩小我的体积（变化）吗，我提前自己变到最小，你能拿我怎么办。）然而这种变化不是没有代价的，蛋白质的结构与其功能是息息相关的。所以通常情况下，深海生物的蛋白酶催化效率要远小于同种类的浅海酶。<\\/p>\\r\\n<p>再来看生物膜。生物膜的主要成分是脂类，其压缩性是大于水的，所以在高压强下，也会发生一系列的结构变化。前面 @苏澄宇已经提到了细胞膜的流动性变化。膜中的脂类为适应环境条件而调整其流动性的机制叫均黏调试（Homeoviscous Adaptation）。此机制在高压和低温下有相同的反应。压强升高或者温度降低都会降低膜的流动性。大约深度每增加 100 米的作用和温度降低 0.13-0.21 摄氏度相同。深海生物为了抵抗这种作用，进化出了一些机制来增加膜的流动性，以保障正常的生理需要。<\\/p>\\r\\n<p>膜的主要结构是两层磷脂夹杂着一些蛋白质<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic2.zhimg.com\\/70\\/c00c8ea31b85848d01efa2802089ed09_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>磷脂的排列结构决定了膜的流动性<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/70\\/89e8e0cc6c636d46436b116c0b8f6010_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>如上图所示，两条烃基链分的越开，膜的流动性越强。所以深海生物的适应就旨在保持磷脂分子抬头挺胸圆规腿，而且可以尽可能的保持这种形态。主要的途径有两种：<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic3.zhimg.com\\/70\\/2383ac72e76b35ee28fba950f8fce13e_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>1. PE （Phosphatidylethanolamine） 和 PC（Phosphatidylcholine） 是两种不同的磷脂分子，其最大的区别，你们也看见了，一个小头，一个大头，其带来的结构变化也是一目了然。所以多使用 PE，就是深海生物的一种进化适应。<\\/p>\\r\\n<p>2. 接下来要谈的就是大家都熟悉的饱和和不饱和脂肪酸。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/70\\/af9ce79d062ae56fc0dcde8be3dd49bf_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>饱和和不饱和脂肪酸差别就在烃基上的那个双键。双键就意味着平面结构（想象一下大闸蟹），导致拐腿那个姿态就变不了了。所以不饱和键的存在，增加了膜的流动性。<\\/p>\\r\\n<p>之前提到低温和高压对膜的适应进化有相似的作用，而全球大洋平均温度是 4 摄氏度，这也就是为什么海洋生物（深海以及冷水）多富含不饱和脂肪酸。<\\/p>\\r\\n<p>总的来说，深海生物对抗高压的方法就是减小自身的压缩性，从而把压强的作用减到最小。<\\/p>\\r\\n<hr \\/>\\r\\n<p>更多讨论，查看 知乎圆桌 &middot;&nbsp;<a class=\\\"internal\\\" href=\\\"http:\\/\\/www.zhihu.com\\/roundtable\\/oceanography\\\">潜入蔚蓝<\\/a><\\/p>\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/20257982\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n<\\/div>\\n<\\/div>";
    private TextView tvContent;
    private WebView webView;
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tvContent);
        tvContent.setText(strDiaryContent);

        webView = (WebView) findViewById(R.id.webview);
        btnTest = (Button) findViewById(R.id.btnTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                webView.loadUrl("http://news.at.zhihu.com/css/news_qa.auto.css?v=1edab");
                webView.loadData(StringUtil.toHTMLString(strHTMLData), "text/html", "UTF-8");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
