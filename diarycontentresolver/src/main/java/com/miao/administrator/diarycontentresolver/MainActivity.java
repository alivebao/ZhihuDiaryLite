package com.miao.administrator.diarycontentresolver;

import android.app.Activity;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends AppCompatActivity {
    private String str1 = "{\"body\":\"<div class=\\\"main-wrap content-wrap\\\">\\n<div class=\\\"headline\\\">\\n\\n<div class=\\\"img-place-holder\\\"><\\/div>\\n\\n\\n\\n<\\/div>\\n\\n<div class=\\\"content-inner\\\">\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">深海生物为什么可以承受如此大的压力？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/da8e974dc_is.jpg\\\">\\n<span class=\\\"author\\\">知乎用户<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p>从海平面开始，深度每增加 10 米，压强增加一个大气压。全球大洋平均深度 4000 米，而在这个深度，压强是 400atm, 什么感觉呢，大约是两只大象站在你的大拇脚趾头上。<\\/p>\\r\\n<p>前面答案大多提到了体内外压力差相等，但是否这就抵消了深海如此大的压强呢？<\\/p>\\r\\n<p>海洋学家出海时很爱干这么一件事：拿一个泡沫杯，绑在采样或者探测仪器上，放入深海，取上来以后，会收获一个&hellip;&hellip;完美缩小的泡沫杯。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/70\\/a5f71e6ebc18c7a58fe09387d6f448d3_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>这个杯子放在任何一个深度，内外压强都是相等的，但它进过高压的洗礼，还是 一夜回到解放前。所以在压强面前，只要有固体形态，有压缩性，都会或多或少受到影响。对于生物体来说，高压强最直接的作用是减少分子的体积而导致的机体结构变化。作为一个分子而言，这压强是十足的作用在其身上的。生物体都是由一个个分子构成的，其主要构成单位蛋白质，以及各种脂膜的结构和功能都相应的发生了一些变化，以适应深海的压强。<\\/p>\\r\\n<p>首先说说蛋白质。既然压强的直接作用是导致体积的变化，深海生物蛋白质的适应也是体现在体积变化。蛋白质不是刚性结构，意味着它可以通过三级或四级结构转化而进行『构象变换』。 此外，蛋白质亚单位组合，辅因子和酶的相互作用，催化反应，都伴随着蛋白质的结构 \\/ 体积变化。深海生物的适应进化便是减少这种体积变化。（粗暴的可以这么理解：你不是要缩小我的体积（变化）吗，我提前自己变到最小，你能拿我怎么办。）然而这种变化不是没有代价的，蛋白质的结构与其功能是息息相关的。所以通常情况下，深海生物的蛋白酶催化效率要远小于同种类的浅海酶。<\\/p>\\r\\n<p>再来看生物膜。生物膜的主要成分是脂类，其压缩性是大于水的，所以在高压强下，也会发生一系列的结构变化。前面 @苏澄宇已经提到了细胞膜的流动性变化。膜中的脂类为适应环境条件而调整其流动性的机制叫均黏调试（Homeoviscous Adaptation）。此机制在高压和低温下有相同的反应。压强升高或者温度降低都会降低膜的流动性。大约深度每增加 100 米的作用和温度降低 0.13-0.21 摄氏度相同。深海生物为了抵抗这种作用，进化出了一些机制来增加膜的流动性，以保障正常的生理需要。<\\/p>\\r\\n<p>膜的主要结构是两层磷脂夹杂着一些蛋白质<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic2.zhimg.com\\/70\\/c00c8ea31b85848d01efa2802089ed09_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>磷脂的排列结构决定了膜的流动性<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/70\\/89e8e0cc6c636d46436b116c0b8f6010_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>如上图所示，两条烃基链分的越开，膜的流动性越强。所以深海生物的适应就旨在保持磷脂分子抬头挺胸圆规腿，而且可以尽可能的保持这种形态。主要的途径有两种：<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic3.zhimg.com\\/70\\/2383ac72e76b35ee28fba950f8fce13e_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>1. PE （Phosphatidylethanolamine） 和 PC（Phosphatidylcholine） 是两种不同的磷脂分子，其最大的区别，你们也看见了，一个小头，一个大头，其带来的结构变化也是一目了然。所以多使用 PE，就是深海生物的一种进化适应。<\\/p>\\r\\n<p>2. 接下来要谈的就是大家都熟悉的饱和和不饱和脂肪酸。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/70\\/af9ce79d062ae56fc0dcde8be3dd49bf_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>饱和和不饱和脂肪酸差别就在烃基上的那个双键。双键就意味着平面结构（想象一下大闸蟹），导致拐腿那个姿态就变不了了。所以不饱和键的存在，增加了膜的流动性。<\\/p>\\r\\n<p>之前提到低温和高压对膜的适应进化有相似的作用，而全球大洋平均温度是 4 摄氏度，这也就是为什么海洋生物（深海以及冷水）多富含不饱和脂肪酸。<\\/p>\\r\\n<p>总的来说，深海生物对抗高压的方法就是减小自身的压缩性，从而把压强的作用减到最小。<\\/p>\\r\\n<hr \\/>\\r\\n<p>更多讨论，查看 知乎圆桌 &middot;&nbsp;<a class=\\\"internal\\\" href=\\\"http:\\/\\/www.zhihu.com\\/roundtable\\/oceanography\\\">潜入蔚蓝<\\/a><\\/p>\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/20257982\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n<\\/div>\\n<\\/div>\",\"image_source\":\"Takuma Kimura \\/ CC BY-SA\",\"title\":\"每天承受那么大压力，它们依然活得好好的\",\"image\":\"http:\\/\\/pic1.zhimg.com\\/4f48e2673fc129758f9f19eab85348b4.jpg\",\"share_url\":\"http:\\/\\/daily.zhihu.com\\/story\\/7363862\",\"js\":[\"http:\\/\\/news.at.zhihu.com\\/js\\/story.js?v=\\/js\\/story.js\"],\"ga_prefix\":\"102910\",\"type\":0,\"id\":7363862,\"css\":[\"http:\\/\\/news.at.zhihu.com\\/css\\/news_qa.auto.css?v=77778\"]}";
    private String str2 = "{\"body\":\"<div class=\\\"main-wrap content-wrap\\\">\\n<div class=\\\"headline\\\">\\n\\n<div class=\\\"img-place-holder\\\"><\\/div>\\n\\n\\n\\n<\\/div>\\n\\n<div class=\\\"content-inner\\\">\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">独家 | 好莱坞的电视剧制片公司如何与编剧签协议？<\\/h2>\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic2.zhimg.com\\/16b7301a5_is.jpg\\\">\\n<span class=\\\"author\\\">刘莐，<\\/span><span class=\\\"bio\\\">如是娱乐法 联合创始人<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p><strong><strong>如是导读<\\/strong><\\/strong><\\/p>\\r\\n<blockquote>一部《伪装者》让大家将视线重新投到了国产电视剧上，微博上掀起了追剧浪潮。优质的电视剧剧本对一部成功的电视剧起了决定性作用，很多人观众也表示「这部剧的制作水准正在逼近美剧水平」。那让我们来涨涨姿势，看看成熟电影工业体系下的好莱坞电视剧制片公司是如何与编剧签协议的。<\\/blockquote>\\r\\n<p>很多人认为电视剧是编剧的艺术。<strong>成功的电视剧编剧经常会在其创作的电视剧中扩大职权，成为整个电视节目的运作人而监督其他编剧的工作，他所关注的范围，也不只是剧本，而是从表演到剪辑，到电视剧制作的各个方面<\\/strong>。作为电视剧制作的首席执行官，这类制片人仅对投资电视剧的制片公司和播放电视剧的广播电视公司（电视台）报告工作，他们的名字通常会署名为执行制片人，出现在电视剧署名的最上方。<\\/p>\\r\\n<p>在行业内，编剧 \\/ 执行制片人的试播剧本创作交易有时被称作「一次性」交易，因为它们是围绕一份单独的试播剧本写作展开的。<\\/p>\\r\\n<p>与电影行业不同的是，电视剧的制作过程需要编剧的持续参与。因此，电视剧剧本协议的谈判内容不仅包括创作试播剧本的酬劳，还包括其他的额外条款，这些额外条款是根据编剧在试播集制作和电视剧项目中的位置设置的。<\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/912aead63b557be4188d489bdf8d0ec7_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>试播剧剧本酬劳<\\/strong><\\/strong><\\/p>\\r\\n<p>协议中首先涉及的通常是剧本酬金。根据目前美国编剧协会协议所规定，一集三十分钟试播剧本的酬金大概是<strong>3 万 8 千美元<\\/strong>，而六十分钟的大约是<strong>5 万 2 千美元<\\/strong>。<\\/p>\\r\\n<p>值得一提的是，所有主要的广播电视公司都是 WGA（美国编剧协会）协议的签约者，因此美国大部分电视剧在制作过程中都受到 WGA 协议的制约。但是 WGA 协议只规定了费用的下限而未规定上限。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>试播剧本写作步骤<\\/strong><\\/strong><\\/p>\\r\\n<p>与故事片写作协议不同，在试播剧本的协议中，双方很少花时间协商剧本写作的具体步骤。这是因为，试播剧本写作报酬中通常涵盖故事构思、初稿、两次修改和一次润色。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>试播剧制作服务<\\/strong><\\/strong><\\/p>\\r\\n<p>倘若制片公司接受剧本并决定根据剧本制作电视剧，在多数情况下，制片人会承诺以一个协议价聘请编剧为试播剧集的执行制片人。<\\/p>\\r\\n<p>此外，编剧还是广播电视公司和制片公司之间的「联络人」。然而也有制片公司不聘请编剧为执行制片人的例子。这种情况下，制片人可能会同意聘请编剧担任监制或级别更低的岗位。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>试播剧制作费<\\/strong><\\/strong><\\/p>\\r\\n<p>本质上，编剧作为执行制片人的费用并不受到 WGA 规定的管制。然而，如果编剧在担任执行制片人期间继续写作剧本（因为在电视剧的制作中很可能需要编剧的参与），她的报酬就不得低于<strong>每周 5 千美金<\\/strong>。这个报酬水平参考自编剧行业协会对「编剧从事附加工作」支付报酬的规定。编剧的试播剧制作费几乎总是附加并独立于试播剧本创作费。例如，一名编剧因撰写试播剧本而获得 5 万美元报酬，此外对制作剧本可能还会获得额外 3 万 5 千美元。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>电视剧服务<\\/strong><\\/strong><\\/p>\\r\\n<p>这些条款是关于，当试播剧被广播电视公司续订时（即成为连续剧之后），编剧服务的性质和范围。<\\/p>\\r\\n<ul>\\r\\n<li><strong>锁定<\\/strong>：制片公司通常会同意将编剧 \\/ 作者「锁定」在电视剧的制作过程中至少一年，多数情况下是两年。这就意味着，如果电视剧成功进入拍摄制作，编剧将获得聘用方的保证，得以作为制片人参与至少一定季数（依据双方协商）的制作。<\\/li>\\r\\n<li><strong>连续剧中的职位<\\/strong>：如果制片公司同意编剧作为试播剧的执行制片人，那么制片公司很有可能在连续剧变为电视剧后，在电视剧的第一季制作中也让编剧担任同样的角色。<\\/li>\\r\\n<li><strong>排他性<\\/strong>：编剧为电视剧制作提供的必要服务通常都应具有排他性，即制片公司要求编剧不得在制作前期及中期为其他人从事剧本创作；而在后期制作阶段，制片公司通常只要求编剧将他的工作列为「第一优先」，而不再是独家专职为其工作。<\\/li>\\r\\n<li><strong>电视连续剧制作费<\\/strong>：通常，编剧电视连续剧的单集制作费（即，就每一集电视剧的制作编剧所获得的费用）会低于试播剧的制作费。这是因为试播剧在制作上的工作量更大。<\\/li>\\r\\n<\\/ul>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>咨询服务<\\/strong><\\/strong><\\/p>\\r\\n<p>通常来说，当试播剧编剧不再为制片公司排他地提供执行制片服务后，制片公司会保证编剧有机会为后续的电视剧提供咨询服务。咨询服务并不具有排他性，因此编剧可以在电视剧中保持一定的参与度、领取报酬，然后还可以同时在该剧以外的地方工作。<\\/p>\\r\\n<p>根据惯例，制片公司会以一种「一比一」的方式对编剧的咨询顾问服务进行锁定。所谓「一比一」就是指，编剧提供全职制片服务多长时间，就得为电视剧提供多长时间的咨询服务。<\\/p>\\r\\n<p>大多数编剧的代理人会要求第一季的咨询费等于编剧最近一次担当该剧执行制片人时所获酬金的一半。但大多制片公司更倾向于将咨询费设为（通常更低的）固定额度的报酬。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>电视剧发行奖金<\\/strong><\\/strong><\\/p>\\r\\n<p>它的意思是，如果广播电视公司根据试播剧决定购买电视剧，制片公司要支付给编剧奖金。对于制片公司来说，它可能不会先提出支付编剧发行奖金，但是如果编剧的代理人或律师提出了这样的要求，制片公司通常就会提供一笔适当的报酬了。<\\/p>\\r\\n<p><strong>▌<strong>版税<\\/strong><\\/strong><\\/p>\\r\\n<p>按照编剧行业协会规则签订的协议一般会规定，编剧或在电视剧中担任「制片人」的编剧在试播剧以外的每集电视剧中，可以分得一笔版税。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>利润分成<\\/strong><\\/strong><\\/p>\\r\\n<p>编剧在电视剧中的利润分成比在电影中重要的多，在电视剧中，编剧也更容易得分成收入。这是因为电视剧编剧通常可以在谈判中争取到 5%以上的分成比例以及对自己有利的计算方式，此外，电视剧一旦获得巨大成功，会带来比成本高出很多的收入，这时，无论电视剧「净收益」如何定义，编剧都极有可能得到报酬分成。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>署名<\\/strong><\\/strong><\\/p>\\r\\n<p>按照编剧行业协会的规定下签订的协议，双方对于署名条款没有什么协商的必要，因为编剧行业协会已经决定了大多数编剧署名的形式, 且这种署名往往与版权条款相绑定。<\\/p>\\r\\n<p>但关于编剧在担任「执行制片人」、「监制」或是「咨询顾问」的署名事项条款，则需要在合同中予以明确的规定。近些年，许多成名编剧除了制片人的署名外还要求「标志署名」（通常是在片尾字幕出现）。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>特别待遇<\\/strong><\\/strong><\\/p>\\r\\n<p>在大多数的电视剧制作协议中，编剧都会要求一些基本的「特别待遇」，包括：（1）在制片公司或电视台要求出差时，乘坐头等舱的权利；（2）住宿；（3）酬劳日结；（4）往返机场、酒店和拍摄场地时制片公司应提供的接送服务等。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>承诺的剧本任务<\\/strong><\\/strong><\\/p>\\r\\n<p>编剧通常会把制片公司必须保证自己至少创作一定集数电视剧剧本的权利写入合同条款，虽然最终是由制片公司决定是否使用（甚至购买）其剧本，但落实最低剧本任务条款就可以使制片公司无论如何都有义务为剧本支付费用，而拥有这项权利，也意味着编剧这笔收入能获得一定保证。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>后续作品创作权利<\\/strong><\\/strong><\\/p>\\r\\n<p>这是指根据原电视剧制作的后续作品进行撰写和制作的「优先谈判权」。即使编剧没有参与它们的创作，如果这些后续作品最终成功上映，他们还是会要求「被动收入」或版税。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>可分割权利<\\/strong><\\/strong><\\/p>\\r\\n<p><img class=\\\"content-image\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/4c05fb52208aa91b090e367bc7c825f8_b.jpg\\\" alt=\\\"\\\" \\/><\\/p>\\r\\n<p>在一部电视剧中获得制片人署名的编剧通常会被赋予可分割权利。虽然这些权利可以通过交易或其他手段转让给制片公司或制片人，但不会只因为他们聘用了这位编剧，可分割权利就自动转移给了他们。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>周转权<\\/strong><\\/strong><\\/p>\\r\\n<p>编剧可以在制片公司决定不制作其作品时，寻找其他制片公司制作其电视剧项目。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>编剧职员<\\/strong><\\/strong><\\/p>\\r\\n<p>一旦试播剧被电视台挑中，制片公司会聘用一批编剧职员，在电视剧制片人的指挥下，协助剧本创作和电视剧制作。根据编剧资历深浅的不同，聘用协议的达成可能不需要什么谈判，也可能需要更多谈判。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>打包协议<\\/strong><\\/strong><\\/p>\\r\\n<p>当制片公司或电视台以合约制或者可以称为签署打包协议的方式签约一名编剧时，他们会一次性付给编剧报酬作为合约期内的打包费用（合约期间的长度通常来说一到两年，有时候也可能再续约一年或一年以上），作为回报，编剧为制片公司或电视网络公司撰写剧本创作和制作电视剧的劳务是排他性的，并且编剧不能在别处任职。此外，合约通常还会规定，编剧要在工作期间内创作至少一定数量的试播剧剧本，以供制片公司或电视网络公司选择。<\\/p>\\r\\n<p>打包协议最常为那些上等水平的电视剧编剧所保留。他们能够通过为某个制片公司提供排他性的服务而获得百万美元的收入。有时，制片公司也会与中等水平的编剧达成大包协议，但报酬要远远低于前者。<\\/p>\\r\\n<p><strong><strong><strong><strong><strong><strong><strong>▌<\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><\\/strong><strong>其他<\\/strong><\\/strong><\\/p>\\r\\n<p>电视剧编剧协议通常还包括以下附加条款：<\\/p>\\r\\n<ul>\\r\\n<li><strong>养老金 \\/ 健康基金<\\/strong>：在商谈属于 WGA 管辖的编剧协议时，编剧的代理人或律师通常会要求制片人认可其有义务为编剧支付 WGA 要求的健康、养老、福利基金。<\\/li>\\r\\n<li><strong>错误与疏忽保险<\\/strong>：像电影编剧一样，电视剧编剧通常也会要求自己被列入到错误与疏忽保险单的附加保险人中。<\\/li>\\r\\n<li><strong>DVD 及蓝光碟<\\/strong>：大多编剧都会在聘用合同中坚持写入这样的条款，要求获得试播剧和每集电视剧的 DVD 和蓝光碟。<\\/li>\\r\\n<li><strong>角色报酬<\\/strong>：在 WGA 协议条款下，对已有的电视剧角色，编剧有权从随后出现该角色的剧集中获得版税。<\\/li>\\r\\n<\\/ul>\\r\\n<p>看完这些内容大家有什么感觉？反正如是君是给编剧大大们的稿酬跪下了！<\\/p>\\n\\n<hr\\/>\\n<p>发自知乎专栏「<a href=\\\"http:\\/\\/zhuanlan.zhihu.com\\/Entertainmentlaw\\/20304547\\\">如是娱乐法评论<\\/a>」<\\/p>\\n\\n<\\/div>\\n<\\/div>\\n<\\/div>\\n\\n\\n<\\/div>\\n<\\/div>\",\"image_source\":\"Yestone.com 版权图片库\",\"title\":\"美剧的编剧们剧本写得好，赚得也够多\",\"image\":\"http:\\/\\/pic3.zhimg.com\\/cdd8b425c43f186bcdf2d17bff9564e2.jpg\",\"share_url\":\"http:\\/\\/daily.zhihu.com\\/story\\/7369259\",\"js\":[\"http:\\/\\/news.at.zhihu.com\\/js\\/story.js?v=\\/js\\/story.js\"],\"ga_prefix\":\"103010\",\"type\":0,\"id\":7369259,\"css\":[\"http:\\/\\/news.at.zhihu.com\\/css\\/news_qa.auto.css?v=77778\"]}";
    private String str3 = "{\"body\":\"<div class=\\\"main-wrap content-wrap\\\">\\n<div class=\\\"headline\\\">\\n\\n<div class=\\\"img-place-holder\\\"><\\/div>\\n\\n\\n\\n<\\/div>\\n\\n<div class=\\\"content-inner\\\">\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">如果真的写一本《金庸群侠传》，应该怎样开头才最惊心动魄？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic1.zhimg.com\\/da8e974dc_is.jpg\\\">\\n<span class=\\\"author\\\">知乎用户，<\\/span><span class=\\\"bio\\\">我的故事很长，比夜晚还长<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n多年以后，面对六大门派，虚竹将会想起姥姥带他去见识冰块的那个遥远的下午。\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/36786594\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">无神论的各位一般从哪里获得精神力量？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic4.zhimg.com\\/50be89eb3_is.jpg\\\">\\n<span class=\\\"author\\\">陈客丁，<\\/span><span class=\\\"bio\\\">南王村养殖厂保安<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p>Deadline.<\\/p>\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/36532219\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">把男朋友打哭了如何哄男朋友？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic3.zhimg.com\\/1f6b2dff32b9cb4f28cd7b2c8ab807e6_is.jpg\\\">\\n<span class=\\\"author\\\">lostman，<\\/span><span class=\\\"bio\\\">ググれカス<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p>下面的答案都很一致的觉得很萌，试想如果文中性别角色对调一下&hellip;&hellip;嗯真是耐人寻味。<\\/p>\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/36771088\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n\\n\\n\\n<div class=\\\"question\\\">\\n<h2 class=\\\"question-title\\\">你见过的最没有生活常识的人是怎样的？<\\/h2>\\n\\n<div class=\\\"answer\\\">\\n\\n<div class=\\\"meta\\\">\\n<img class=\\\"avatar\\\" src=\\\"http:\\/\\/pic2.zhimg.com\\/5a6cede61_is.jpg\\\">\\n<span class=\\\"author\\\">史坤林，<\\/span><span class=\\\"bio\\\">专业被骂的手游策划<\\/span>\\n<\\/div>\\n\\n<div class=\\\"content\\\">\\n<p>「周末我和小明去爬珠穆朗玛峰，据说是世界最高的山峰，我们爬了一上午才爬到半山腰。中午我们只好在麦当劳吃了午饭。晚上，我们终于爬到了山顶，看见山顶的樱花盛开，我觉得我们又度过了一个有意义的周末。」<\\/p>\\n<\\/div>\\n<\\/div>\\n\\n\\n<div class=\\\"view-more\\\"><a href=\\\"http:\\/\\/www.zhihu.com\\/question\\/30868971\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"><\\/span><\\/a><\\/div>\\n\\n<\\/div>\\n\\n\\n<\\/div>\\n<\\/div>\",\"image_source\":\"Yestone.com 版权图片库\",\"section_thumbnail\":\"http:\\/\\/pic2.zhimg.com\\/724e2bdfc5d184d7f884893dca93bb11.jpg\",\"title\":\"瞎扯 · 如何正确地吐槽\",\"image\":\"http:\\/\\/pic2.zhimg.com\\/8b30cb3c1ae52509fb7151ab876829a1.jpg\",\"section_id\":2,\"share_url\":\"http:\\/\\/daily.zhihu.com\\/story\\/7368886\",\"js\":[\"http:\\/\\/news.at.zhihu.com\\/js\\/story.js?v=\\/js\\/story.js\"],\"section_name\":\"瞎扯\",\"ga_prefix\":\"103006\",\"type\":0,\"id\":7368886,\"css\":[\"http:\\/\\/news.at.zhihu.com\\/css\\/news_qa.auto.css?v=77778\"]}";

    private TextView tvContent;
    private WebView webView;
    private Button btnTest;
    private Button btnTest2;
    private Button btnTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContent = (TextView) findViewById(R.id.tvContent);

        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings(); // webView: 类WebView的实例
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);  //就是这句

        btnTest = (Button) findViewById(R.id.btnTest1);
        btnTest2 = (Button) findViewById(R.id.btnTest2);
        btnTest3 = (Button) findViewById(R.id.btnTest3);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = StringUtil.getQuestionURLAdapterPic(str1);
                Log.e("str at Main", str);
                webView.loadData(str, "text/html;charset=UTF-8", null);
//                setWebViewContent(webView, str1);
                tvContent.setText(str1);
            }
        });
        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = StringUtil.getQuesionURL(str2);
                Log.e("str at Main", str);
                webView.loadData(str, "text/html;charset=UTF-8", null);
                tvContent.setText(str2);
            }
        });
        btnTest3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = StringUtil.getQuesionURL(str3);
                Log.e("str at Main", str);
                webView.loadData(str, "text/html;charset=UTF-8", null);
                tvContent.setText(str3);
            }
        });
        btnTest.callOnClick();
    }

    private void setWebViewContent(WebView mWebView, String str) {
        try {
            JSONObject newsDetail = new JSONObject(str);
            if (newsDetail.has("body")) {
                Document doc = Jsoup.parse(newsDetail.getString("body"));

                Elements elementImgs = doc.getElementsByTag("img");//获取所有img标签

                for (Element img : elementImgs) {
                    img.attr("width", "100%");//设置width属性
                }
                webView.loadData(doc.toString(), "text/html;charset=UTF-8", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
