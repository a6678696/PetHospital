/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24 : Database - db_pethospital
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_pethospital` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `db_pethospital`;

/*Table structure for table `t_article` */

DROP TABLE IF EXISTS `t_article`;

CREATE TABLE `t_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) DEFAULT NULL,
  `releaseDate` datetime DEFAULT NULL,
  `click` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`),
  KEY `typeId` (`typeId`),
  CONSTRAINT `t_article_ibfk_1` FOREIGN KEY (`typeId`) REFERENCES `t_articletype` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `t_article` */

insert  into `t_article`(`id`,`title`,`releaseDate`,`click`,`typeId`,`content`) values (1,'金毛','2020-01-26 23:04:43',75,4,'<h1 style=\"margin-left:0px; margin-right:0px\">金毛</h1>\r\n\r\n<p style=\"text-align:center\">&nbsp;</p>\r\n\r\n<ul>\r\n	<li>\r\n	<p>基本信息</p>\r\n	</li>\r\n	<li>\r\n	<p><span style=\"color:#999999\">英文名：</span>Golden Retriever</p>\r\n	</li>\r\n	<li>\r\n	<p><span style=\"color:#999999\">性　格：</span>活泼、忠诚、憨厚、友善</p>\r\n	</li>\r\n	<li>\r\n	<p><span style=\"color:#999999\">祖　籍：</span>苏格兰</p>\r\n	</li>\r\n	<li>\r\n	<p><span style=\"color:#999999\">易患病：</span>髋关节发育不良</p>\r\n	</li>\r\n	<li>\r\n	<p><span style=\"color:#999999\">寿　命：</span>10&mdash;15年</p>\r\n	</li>\r\n	<li>\r\n	<p><span style=\"color:#999999\">价　格：</span>800-3000元</p>\r\n\r\n	<p style=\"text-align:center\"><img alt=\"\" src=\"/static/images/articleImage/20200128023933.jpg\" style=\"height:420px; width:600px\" /></p>\r\n	</li>\r\n</ul>\r\n\r\n<p><span style=\"font-family:&quot;Microsoft YaHei&quot;; font-size:24px\">1.金毛犬品种简介</span></p>\r\n\r\n<p><span style=\"font-family:&quot;Microsoft YaHei&quot;\">金毛巡回猎犬（Golden Retriever），原产于苏格兰，祖先有雪达犬血统，因有较强的游泳能力，并能把猎物从水中叼回给主人，故最初用作狩猎及巡回被枪猎射落的水鸟，AKC分类属于运动犬组。</span><br />\r\n<strong>　　中文学名：</strong><a href=\"http://www.boqii.com/tag/2024/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">金毛寻回猎犬</a><br />\r\n<strong>　　拉丁学名：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">Golden Retriever</span><br />\r\n<strong>　　别称：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">金毛、金毛犬、黄金猎犬</span><br />\r\n<strong>　　界：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">动物界</span><br />\r\n<strong>　　门：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">脊索动物</span><br />\r\n<strong>　　亚门：</strong><a href=\"http://www.boqii.com/tag/3198/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">脊椎动物</a><br />\r\n<strong>　　纲：</strong><a href=\"http://www.boqii.com/tag/215/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">哺乳</a><br />\r\n<strong>　　亚纲：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">哺乳</span><br />\r\n<strong>　　科：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">犬</span><br />\r\n<strong>　　<a href=\"http://www.boqii.com/tag/5751/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">犬种</a>智商：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">排名第 4</span></p>\r\n\r\n<h2 style=\"margin-left:0px; margin-right:0px\">2.金毛犬形态特征</h2>\r\n\r\n<p><span style=\"font-family:&quot;Microsoft YaHei&quot;\">金毛犬在犬的智商中排名在第四位，由于金毛犬有着一双温柔的眼睛、微笑的脸庞、天使般完美的性格、一身笼罩着天堂光辉的金色被毛，目前多被用作家庭犬及导盲犬。美国犬业俱乐部(American Kennel Club,AKC)标准规定其毛皮是&ldquo;丰富的，有光泽的由不同层次的金色(rich，lustrous golden of various shades)&rdquo;，不允许有过于浅或者过于深的颜色。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　它本身分为淡奶油(色素不够)及深咖啡二大类的颜色。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　金毛寻回犬主要的换毛期为一年二次，但由于体积较大毛量比小型犬多，常被误认为很会掉毛，无论大型犬或小型犬都会掉毛，平时的掉毛只是每天的新陈代谢而已，只要常常为它梳毛就可减少这困扰</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　金毛是一个均称、有力、活泼的犬种，学名为</span><a href=\"http://www.boqii.com/tag/2024/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">金毛寻回猎犬</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">，稳固、身体各部位配合合理，腿既不太长也不笨拙，表情友善，个性热情、机警、自信。因其是一种猎犬，在困苦的工作环境中才能</span><a href=\"http://www.boqii.com/tag/5807/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">表现</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">出他的本质特点。他的总体外貌、平衡、步态和该犬种的用途应得到比身体任何一个单独部分更多的重视。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>缺陷：</strong><span style=\"font-family:&quot;Microsoft YaHei&quot;\">任何与该犬种的理想描述相背离均可视为缺陷，缺陷的严重程度根据其与该犬种的用途相矛盾或与该犬种的特质相悖的程度决定。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>失格条件</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　1.身高低于或高于标准身高的2.5m。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　2.牙齿呈上腭式突出或下腭式突出。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　3.胸部有大量白毛或白斑。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<h2 style=\"margin-left:0px; margin-right:0px\">3.金毛犬性格特点</h2>\r\n\r\n<p><span style=\"font-family:&quot;Microsoft YaHei&quot;\">在很多家庭中，人们对金毛犬的大概认识就是金毛犬性格活泼、爱撒娇、忠诚、憨厚，我么在玩耍的时候都可以看到他的踪影，他对任何人都友善，可以和人类成为好朋友，因为他的好脾气以及聪明的脑袋，现在已有很多金毛犬被训练成导盲犬，为人类做贡献。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>性格特点<br />\r\n　　玩耍</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　狗儿忙碌地不断将东西捡回来，最擅长的就是捡拖鞋、鞋子、球和布娃娃的等等。最喜欢的玩具是球形玩具。来到饲主的身边，抬起一条腿，吸引饲主的注意力，或是飞奔过来，和饲主撒娇，要求一起玩耍。会&ldquo;哼、哼&rdquo;的用鼻音撒娇，在饲主的周围不断绕圈子，或是一看到什么东西，就立刻咬在嘴里，跑向饲主；即使是</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　一大块枯木也不放过。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>撒娇</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　发出&ldquo;哼，哼&rdquo;带着鼻音的撒娇声，身体不断靠近，希望饲主可以抚摸它。它会穿过饲主的跨下，或是露出肚子躺下向饲主&ldquo;耍赖&rdquo;。这种时候，不要凶巴巴的把它赶走，即使只有片刻，也努力和它保持肢体接触。这样可使它感受到饲主的爱。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>寂寞</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　刚离开母亲的小狗或是一直独自留在家里时，就会&ldquo;呜~~呜~~&rdquo;的叫着。垂着肩膀，低着头，全身无力的站在它的&ldquo;地盘&rdquo;。即使有球滚过来，也不会看一眼。&ldquo;呼&rdquo;的叹一个气，努力想要使自己睡一觉。这种时候，只有饲主的爱才能给它温柔。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>服从</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　狗对自己认同的首领会完全服从。爱犬的主人当然就是饲主，它只会对自己的主人做出仰躺，露出最大弱点的肚子这种毫无防备的动作，代表自己完全没有反抗的意思，是绝对服从的信号。另外，尾巴向后伸直，将腹部趴在地面，塌着耳朵，哀怨的抬头看着饲主时，代表服从的意思。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　</span><strong>　兴奋</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　为了怕玩具弄丢了，会用前腿用力夹住玩具，或是用牙齿咬，摇晃。由于太兴奋，还会流口水或是挺起肚子。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　</span><strong>　满足</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　在充分活动，玩耍后，就会懒洋洋地躺下，沉浸在</span><a href=\"http://www.boqii.com/tag/3254/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">心情</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">愉快的疲劳感中，内心倍感满足。一边盯着饲主和家人的一举一动，确认大家并没有忘记它的存在。心情好的时候，还会发出愉悦地撒娇声。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　</span><strong>　喜悦</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　吃饭和散步是快乐时光。垂下耳朵，眯起眼睛，吐出舌头是它在心情愉快时的表情。尾巴用力摇晃着，身体左右扭动，步履轻盈。尾巴拼命摇晃时，是它最高兴的时候。有时候，它会皱起鼻子，翘起上唇，做出微笑的表现。当它从鼻子中发出&ldquo;哼，哼&rdquo;声时，也是高兴的象征。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>累了</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　充分运动后的疲劳也令狗感到不堪负荷。小狗会立刻昏昏欲睡，打着哈欠，不一会儿就进入梦乡。当它深深入睡时，怎么叫，也叫不醒它，不妨让它好好的睡上一大觉。俗话说&ldquo;一瞑大一寸&rdquo;，当它好好的睡了一觉醒来后，又会精力充沛的四处活动，直到累了为止。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>思考</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　在思考时，狗也会沉默。但狗不会沉思，因为这不符合它的个性。它很快的就会投入下一个行动，并十分热衷其中。当它在行动与行动之间的瞬间进行思考，并不断重复这种思考后，它可以从中学习很多。因此，重复练习是调教的关键。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>诉说</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　当狗想要诉说什么时，会拼命用这种&ldquo;欲言又止&rdquo;的眼神抬头望着饲主。它会不厌其烦的做出相同的动作，进而发出低鸣的叫声，希望饲主能够了解它的心情。这个时候，应该努力从它的眼睛中察觉它的要求。狗的诉求都十分简单，纯朴，它绝对不可能提出奢侈的要求。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>无聊</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　狗之所以会感到无聊，是因为在玩得很尽兴后，暂时不知道自己接下来该做什么。于是，就觉得浑身懒洋洋的，只有眼睛不断寻找着新的调皮对象。但狗无法一直都沉浸在这种无聊中，只要一有刺激它好奇心的事物，就会立即起身，完全忘记刚才的自己。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　</span><strong>　兴趣正浓</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　狗的好奇心十分旺盛。第一次看到动物和昆虫时。耳朵会敏感的竖起，尾巴不断摇晃，带着些许的紧张，慢慢靠近。嗅着味道，当了解&ldquo;一切安全&rdquo;后，就会用鼻子闻，用嘴巴咬&hellip;&hellip;当感到奇怪或是遇到奇怪的东西时，会像人一样歪着脖子，陷入思考。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>快乐</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　饲主和自己一起玩耍时，会令它感到乐不可支。竖起尾巴，伸长脖子，轻快的一路小跑，高兴时，不停的跳跃，全身表现出无法克制的快乐。也会上下摇动耳朵，吐出舌头&ldquo;哈，哈&rdquo;地向饲主撒娇。</span></p>\r\n\r\n<h2 style=\"margin-left:0px; margin-right:0px\">4.金毛犬养护知识</h2>\r\n\r\n<p><span style=\"font-family:&quot;Microsoft YaHei&quot;\">金毛犬给人感觉憨厚可爱、聪明乖巧，听话可人，早期是为了用作猎捕野禽的寻回犬而培养的，游泳的续航力极佳。现在大多作为导盲犬与</span><a href=\"http://www.boqii.com/tag/326/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">宠物</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">狗。对小学生或者孩子十分友善，金毛的独特之处就是对人友善，讨人欢心。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>养护知识<br />\r\n　　必须准备</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　准备领养一只小金毛幼犬前，必须做的准备如下：</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　1.定期带金毛狗狗去做预防注射。此外，植入芯片、疾病治疗，都是金毛成长过程上必须费心的事情。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　2.由于金毛幼犬尚未学会定点排泄，排泄的次数又多。因此，饲主也许要很有耐心地一整天拿着报纸，跟在金毛的屁股后面等着接受狗狗的便和尿。同时小金毛一有动静就马上抱着它去指定地点开始学习定点排泄。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　3.饲主要费心梳理金毛那厚厚的背毛，不但每天需梳毛整理，而且，狗狗在吃饭的时候，还需要注意不要让它的嘴巴吃脏，也要避免被食物弄脏。另外，平时环境的</span><a href=\"http://www.boqii.com/tag/3024/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">清洁</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">更不能疏忽；要知道小金毛狗会在地下滚，把自己弄得脏兮兮的。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　4.要想清楚是否愿意让狗狗一辈子幸福，以及是否愿意不断的为狗狗把屎把尿，洗褥子被子，和它共度十几年如此的生活。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　5.金毛狗狗的寿命一般为10年-15年，是很短暂的。所以，领养一只金毛狗，饲主需负起这十几年的责任。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　6.金毛犬跟小孩一样，肚子里会有寄生虫，应在小时候就开始定期为金毛犬体内外驱虫。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　7.有些金毛犬由于因遗传因素或后天因素导致的金毛犬髋关节发育不良，在生活中照顾金毛犬时，主人应特别小心谨慎。</span></p>\r\n\r\n<h2 style=\"margin-left:0px; margin-right:0px\">5.金毛犬喂食要点</h2>\r\n\r\n<p><span style=\"font-family:&quot;Microsoft YaHei&quot;\">金毛犬是个不挑食的好孩子，既乖巧又听话，因</span><a href=\"http://www.boqii.com/tag/3060/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">体型</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">较大所以胃口也相对比较大，对于一只大型犬来说健康的饮食是需要严格把关的。金毛犬可以吃什么？不可以吃什么呢？</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>喂食要点</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　金毛犬最好的食物是狗粮，家制食物达到合理的营养配比非常困难，狗粮是按照这样的营养配比加工而成的，是狗狗最好的</span><a href=\"http://www.boqii.com/tag/4739/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">食品</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">。另外如给爱犬食用家制食品，注意放极少量盐煮熟食用，过量的盐和生的食品都有损犬的健康。 如不能给它吃狗粮而吃家制食物时，要注意搭配保证营养均衡。动物内脏(注意：不要长期喂食猪肝，会中毒)，肉类，玉米粉，鱼肉(注意：鱼的硬刺可能会卡住，最好挑去)，胡萝卜等，都可以是犬的食品，几乎不放盐煮熟后喂食。另外喂食幼犬狗粮时需和拌少许温水。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>一、金毛犬<a href=\"http://www.boqii.com/tag/3971/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">喜欢</a>吃什么</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　1.金毛是很喜欢吃水果的，因为水果是甜甜的、清脆多汁，像是苹果、梨、樱桃、西瓜、桃子都可以给金毛吃点儿，也可以香蕉不过要考虑金毛的肠胃受不受得了。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　2.作为狗狗主食的狗粮金毛是喜欢吃的，有时候可以加点其他东西给它吃，比如说肉啊、蔬菜啊、鸡肝等等，这些金毛犬也是喜欢吃的。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>二、金毛犬不能吃什么</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　1.金毛总是很喜欢吃主人吃的食物，但是人吃的食物并不适合金毛吃，例如面包，金毛就不能吃，因为盐分太高了，如果金毛吃的盐分多了，金毛那一身亮丽的金毛就要掉了。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　2.洋葱、大蒜之类的调味品也不可以给金毛吃，这些食物对金毛的血液有强烈的毒性，吃多了会引起急性贫血，甚至危及性命。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　3.香辣的调味料刺激性强、气味浓重的食物相信有着敏感度嗅觉的金毛是不愿意吃的。像是芥末及辣椒含量太多的食物，会造成金毛的口、胃肠溃烂现象，所以千万不能喂。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　4.鸡鸭骨头不可以喂给金毛。这些骨头又细又尖，还很坚硬，不易消化，会划伤金毛的肠胃，造成大便带血的情况。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　5.不可以喂牛奶给金毛，牛奶不易消化，会让金毛拉肚子的。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　6.金毛不能吃的水果首推就是葡萄，葡萄会导致金毛肾衰竭，甚至会死亡。还有苹果、梨之类水果的核也不能吃，有毒的。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　</span><strong>三、金毛犬吃什么对毛好</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　要使犬毛有光泽、美观，可每天给犬多喂富含蛋白质的饲料。含有维生素E、维生素D的添加剂和海藻类食物、蔬菜等，如瘦肉、煮熟的蛋黄、</span><a href=\"http://www.boqii.com/tag/557/\" style=\"color: rgb(0, 0, 0); text-decoration-line: none; font-family: &quot;Microsoft YaHei&quot;; border-bottom: 1px dotted rgb(254, 115, 12);\" target=\"_blank\">植物</a><span style=\"font-family:&quot;Microsoft YaHei&quot;\">油等，少喂富含糖份、盐份、淀粉等食物。</span><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　</span><strong>　四、老年金毛犬的喂食注意事项</strong><br />\r\n<span style=\"font-family:&quot;Microsoft YaHei&quot;\">　　大多数金毛老狗由于活动减少会变得很胖，因此要注意控制食量，多饲喂些含维生素的食物。睡前一杯酸奶，可以助消化。</span></p>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p>&nbsp;</p>\r\n'),(3,'哈士奇','2020-01-27 00:17:10',23,4,'<p><span style=\"font-size:16px\">基本信息</span></p>\r\n\r\n<p><span style=\"font-size:16px\">英文名：<em>Siberian Huskiy</em>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</span></p>\r\n\r\n<p><span style=\"font-size:16px\">性　格：<em>聪明机灵、极度热情、神经质</em></span></p>\r\n\r\n<p><span style=\"font-size:16px\">祖　籍：<em>俄罗斯</em>&nbsp;</span></p>\r\n\r\n<p><span style=\"font-size:16px\">易患病：<em>肠胃疾病</em></span></p>\r\n\r\n<p><span style=\"font-size:16px\">寿　命：<em>9-15年</em>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span></p>\r\n\r\n<p><span style=\"font-size:16px\">价　格：<em>2000-4000元</em></span></p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"\" src=\"/static/images/articleImage/20200127001123.jpg\" style=\"width:600px\" /></p>\r\n\r\n<h2>哈士奇品种简介</h2>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size:16px\">西伯利亚<a href=\"http://www.boqii.com/tag/3112/\" target=\"_blank\">雪橇犬</a>（Siberian Huskiy)又称为哈士奇，原产于西伯利亚<a href=\"http://www.boqii.com/tag/6316/\" target=\"_blank\">地区</a>，AKC分类属于工作犬组。<a href=\"http://www.boqii.com/tag/2025/\" target=\"_blank\">西伯利亚雪橇犬</a>是东西伯利亚游牧民族伊奴特乔克治族饲养的犬种，长期担任拉雪橇。引导驯鹿及守卫等工作。20世纪初，被毛皮商人带至美国，多年来，一直成为举世闻名的拉雪橇竞赛冠军犬。目前，西伯利亚雪橇犬多被用作伴侣犬。家庭玩赏犬。<br />\r\n　　<strong>中文学名：</strong>西伯利亚雪橇犬<br />\r\n　　<strong>拉丁学名：</strong>Siberian Huskiy<br />\r\n　<strong>　别称：</strong>哈士奇<br />\r\n　　<strong>界：</strong>动物界<br />\r\n　　<strong>门：</strong>动物门<br />\r\n　　<strong>亚门：</strong>脊索椎动物亚门<br />\r\n　　<strong>纲：</strong>哺乳纲<br />\r\n　　<strong>亚纲：</strong>兽亚纲<br />\r\n　<strong>　目：</strong>食肉目<br />\r\n　　<strong>科：</strong>犬科<br />\r\n　<strong>　亚科：</strong>犬亚科<br />\r\n　<strong>　属：</strong>犬属<br />\r\n　<strong>　种：</strong>狼<br />\r\n　<strong>　亚种：</strong>家犬<br />\r\n　<strong>　分布区域：</strong>西伯利亚东北部<br />\r\n<strong>　　原产地：</strong>俄罗斯西伯利亚地区<br />\r\n　<strong>　原始用途：</strong>雪地雪橇犬<br />\r\n<strong>　　今日用途：</strong>伴侣犬、雪橇竞赛犬<br />\r\n　　<strong>体型：<u><a href=\"http://www.boqii.com/tag/3189/\" target=\"_blank\">中型犬</a></u></strong></span></p>\r\n\r\n<h2>哈士奇形态特征</h2>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; <span style=\"font-size:16px\">&nbsp; 西伯利亚雪橇犬是一种原始的古老犬种，因它的独特嘶哑的叫声被称之为当今的哈士奇。很早前哈士奇是最原始的交通工具专门拉雪橇的，并用这种狗猎取和饲养驯鹿，或者繁殖这种狗，然后带出他们居住的冻土地，换取温饱。典型狼性犬。<br />\r\n　　<strong>形态特征</strong><br />\r\n　　西伯利亚雪撬犬有着比绝大多数犬种都要厚的毛发。它们毛发的颜色和花纹有很多种类，通常它们有着白色的爪和四肢、面部的花纹和较尖的尾部，最常见的毛色搭配有黑夹白、灰夹白、铜红色（copper-red）夹白和纯白色，很多个体还有褐色、微红色毛，灰棕色阴影或者杂色斑点。面部出现类似面具、眼镜形状各种各样的花纹也是很常见的。尽管体型较小而且有着较为柔顺的毛发，西伯利亚雪撬犬都有着和狼相似的外观，因为它们的基因是比其他种类的犬最接近原祖的狼。<br />\r\n　　<strong>眼睛</strong><br />\r\n　　西伯利亚雪撬犬的眼睛颜色通常是棕色、浅褐色或蓝色的。浅蓝色眼色是一种普遍眼色，但也有例外，一只狗可能有一只眼是棕色或浅褐色的，而另一只却是蓝色的，这种现象被称作&quot;bi-eyed&quot;；或者一只眼是蓝色的而另一只眼的虹膜是杂色的，即虹膜异色症，被饲养西伯利亚雪撬犬的爱好者称为&quot;parti-eyed&quot;。在被人们普遍豢养的犬种里，西伯利亚雪撬犬是少有的两只眼睛可以有不同颜色的犬种，同时，它也是少数几种普遍眼色为蓝色的犬种之一。<br />\r\n　　<strong>耳朵与尾巴</strong><br />\r\n　　它的耳朵呈三角形，毛发浓密，大小中等，一般直立；尾部像毛刷一样，有着类似于狐狸尾巴的外形，通常呈向上的镰刀状。<br />\r\n　　西伯利亚雪撬犬的毛发由两层组成：浓密、开司米状的下层毛和长、较粗糙且含有短、直卫毛（guard hair）的上层毛。它们一年只脱一次下层毛，这个旧毛的脱落过程通常被称为吹下他们的毛（blowing their coat）。主要居住在室内的犬只一般整年也不会完整地脱一次毛，因此<a href=\"http://www.boqii.com/tag/439/\" target=\"_blank\">脱毛</a>并不很多。另外，它们并不用经常刷毛；由于弄脏的毛发会自然脱去，洗澡通常也不是必需的。并且，这种狗也会经常像猫一样自己仔细清理自己的毛发。健康的西伯利亚雪撬犬是没有体味的。它们的耳朵很柔软，并且听觉也很好。<br />\r\n<strong>　　鼻子</strong><br />\r\n　　像所有的狗一样，西伯利亚雪撬犬的鼻子通常都是凉且潮湿的。 在某些情况下，西伯利亚雪撬犬能表现出所谓&#39;雪鼻&#39;或&#39;冬鼻&#39;的现象。这种现象学术上被称作&quot;hypopigmentation&quot;，它是由于冬季里缺少阳光造成的，这导致了鼻（或其一部分）褪色成棕色或粉红。在夏季到来时便能恢复正常。雪鼻现象在其它的短毛种类里也有出现；老年犬只的这种颜色变化可能是永久的，尽管它并不与疾病相联系。<br />\r\n　<strong>　步态</strong><br />\r\n　　平稳舒畅，脚步轻快而不费力， 在比赛时不宜拉得太紧，应该使其速度快跑，以展示前肢良好的伸展性和后肢强大的驱动力。行进时从前向后看，不是单项运动，随着速度的加快，腿逐渐向前伸展，直至脚趾全部落在身体纵向中轴线上，当脚印集中在一条线上后，前腿和后腿都笔直地向前伸出，肘部和膝关节都不外翻或内翻，同时背线保持紧张和水平。</span></p>\r\n\r\n<h2>哈士奇性格特点</h2>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<span style=\"font-size:16px\">哈士奇的外表英俊潇洒，精致的五官和丰富的肢体语言充满了奇特的表现，无需复杂的交谈，就能轻易了解他的喜怒哀乐。哈士奇时常会有点神经质。<br />\r\n　　<strong>神经质</strong><br />\r\n　　小哈都有一点神经质，特别是母哈。总是莫名其妙的做一些你崩溃的事情，比如走在马路上突然啃完青草就开始狂奔，在屋里到处乱窜然后开始原地打转等等。你要有十足的心理准备，认为它是正常的在发神经。<br />\r\n　　<strong>十足的<a href=\"http://www.boqii.com/tag/292/\" target=\"_blank\">破坏</a>分子</strong><br />\r\n　　家里的任何东西，它都会细心的帮你检查N遍，以考究你的购买物品的坚硬程度。这种认真的程度，到了我一个朋友家一天就要买一个脸盆的地步。不但考验了你的购买能力，还考验了你的经济能力。<br />\r\n　<strong>　极度自由散漫</strong><br />\r\n　　一出门，小哈就象被你虐待N久一样逃离你的视线，一般唤回的概率在30%以下。我记得有个朋友跟我分析，说是四条腿的小哈总认为两条腿的父母能追的上它&hellip;&hellip;反正建议所有养小哈的用户，全部牵溜。没有十足把握它不跑，千万别松绳子。想一只长的象狼一样的小哈能乖乖的跟在自己后面的散步，而不到处乱跑的，那是做梦。<br />\r\n　<strong>　特殊的肠胃</strong><br />\r\n　　小哈太容易<a href=\"http://www.boqii.com/tag/970/\" target=\"_blank\">拉肚子</a>了，饭后喝多了水拉肚子，吃的太油拉肚子，吃惯了狗粮突然给它吃个馒头拉肚子，反正就是容易拉肚子。<br />\r\n　　<strong>精力旺盛</strong><br />\r\n　　它总是要玩、要跑、要跳，折磨的你累的想跳楼，它依旧叼着球过来给你一身口水。甚至在你还没睡醒睁眼的时候，跳上床以要和你玩的理由来折磨你。<br />\r\n　<strong>　极度热情</strong><br />\r\n　　小哈对你热情，对其他的人，一样的热情。比起对你的热情，也许对别人的热情还要疯狂一些。<br />\r\n　　<strong>无视你的存在</strong><br />\r\n　　到了外面，不管你怎么喊它，它都自顾自的溜达，反正不理你就是不理你。<br />\r\n　<strong>　不喜吠叫</strong><br />\r\n　　哈士奇吠叫的时候很少，它们只会在一些特殊情况下，发出狼嚎般的声音，虽然这种声音在晚上听起来有点让人毛骨悚然，但是却正适合了它狼般的外貌，可能很多人还会以此为傲。在大多数情况下，哈士奇几乎不发出声音，不少狗主人甚至会怀疑自己养了只哑巴狗<br />\r\n　　<strong>聪明机灵</strong><br />\r\n　　哈士奇好奇心强且精力旺盛，是一种相当聪明的狗，在过去被用来在茫茫白雪中拉雪橇，为雪地中的人们指引方向。</span></p>\r\n\r\n<h2><span style=\"font-size:16px\">哈士奇养护知识</span></h2>\r\n\r\n<p><span style=\"font-size:16px\">&nbsp; &nbsp; &nbsp; &nbsp;哈士奇虽然看着一副冷漠无情的样子，事实上，哈士奇对人很友好、温柔、热情的。喜欢与人交往是哈士奇的典型性格。通常不表现出护卫犬强烈的领地占有欲，不对陌生人过多的怀疑，也不会攻击其他犬类。因此有很多人喜欢哈士奇。他对主人非常忠诚，一条忠诚的小狗有一个健康的身体是非常重要的。<br />\r\n　　<strong>养护知识</strong><br />\r\n<strong>　　哈士奇如何减肥</strong><br />\r\n　　如果家养<a href=\"http://www.boqii.com/tag/326/\" target=\"_blank\">宠物</a>犬过于肥胖，不仅会失去美感.也会让犬变懒、不能尽忠职守，因此应注意适时减肥。<br />\r\n　　一般犬体重超过了该犬品种标准体重10%以上即为过于肥胖。其原因多是肠胃强壮，吃了过多的淀肠类食物及脂肪。<br />\r\n　　<strong>减肥的方法主要是：</strong><br />\r\n　　1.少淀粉和脂类食物犬日粮中应减少淀粉和脂类食物含量，增加<a href=\"http://www.boqii.com/tag/4432/\" target=\"_blank\">鱼</a>汤、内汤和蔬菜类食物。<br />\r\n　　2.杜绝零食玩赏犬喜向主人讨吃食物，因此，应停止甜糖果类零食。<br />\r\n　　3.防止便秘犬食中可适当增加&mdash;些含纤维家的蔬菜和含膘酸较多的糖类食物，使肠通便。<br />\r\n　　在减肥过程中应逐渐过渡，热量不可突然大幅度减少，而只减少一顿喂食。<br />\r\n　　<strong>怎么控制哈士奇食量</strong><br />\r\n　　狗狗的食量是个大问题，吃多了容易发胖;少了，容易营养不良。所以控制哈士奇的食量很重要，小编为您具体介绍不同状态的狗狗的食量问题。<br />\r\n　　首先狗主要注意一点，不要用剩菜喂养哈士奇。许多人觉得人吃的东西非常有营养，或者怕浪费或者省时间，就用剩饭喂狗狗。但是剩饭中往往会混有尖锐的鱼刺或者骨头，这些都会导致哈士奇口腔受伤，严重时会引起感染。所以为了你的哈士奇安全，首先不要偷懒，用剩饭喂它们。<br />\r\n　　其次给哈士奇喂养的食物，不论是动物食品、谷物食品、还是蔬菜，都应洗净并且加热，以防小哈中毒。尤其夏天，食物更容易变质变坏。<br />\r\n　　1.幼年的狗狗：在生长期的幼犬吃东西是十分疯狂的，如果不适当的控制喂给量，狗狗很容易撑着，所以这个时候控制狗狗的食量是必须的。不过还要说一句，如果盲目的少给会引起狗狗的营养不良，最好的办法是参考狗狗粮食袋上针对不同体重不同生长期的参考喂食量，通常大品牌的狗粮袋上都会有。<br />\r\n　　2.年老的狗狗：年老的狗狗一来消化能力差了，二来许多老年疾病都会因为食物中含有太多的蛋白质而引起病情的恶化。不过还好的就是，狗狗进入老年食欲也会下降，所以对于年老的狗狗控制食量似乎倒不是特别难。<br />\r\n　　3.肥胖的狗狗：有些狗狗的品种天生就容易发胖，比如巴哥、斗牛、京吧等等，所以他们要比其它的哈士奇种在喂养的时候更注意一下它们的饭量。<br />\r\n　　4.绝育的哈士奇狗：做了绝育的狗狗很容易发胖，而且食欲也很好，为了减少因为肥胖引起的其它疾病，我们要在狗狗做了绝育手术伤口恢复完开始，就给狗狗限制饭量。<br />\r\n　　控制狗狗吃东西有的时候真是挺难的，通常我们都没法忍受狗狗期待的眼神，不过把狗狗喂馋了倒是有一个好处，就是你要是想让它少吃就给它纯狗粮就成了。<br />\r\n　　<strong>饲养注意事项</strong><br />\r\n　　第一，每天应有适当的运动。不能凭小哈士奇的意志随随便便，时而一日数次，时而数天运动一次。在户外牵引运动前，应先 让他们自由活动数分钟以排便，在运动中要保持正确的行走 姿势，与主人保持适当的距离，纠正或前或后，或左或右的 行走习惯。<br />\r\n　　第二，狗狗在小的时候，我们应该多给狗狗一点点的关爱，再有的就是小狗狗正在发育的阶段，应该让狗狗吃一些营养比较全面的食物，在这里，推荐大家给狗狗吃麦顿狗粮，改善狗狗的毛发和泪痕，尤其是增强狗狗的骨骼发育!<br />\r\n　　第三，应时常变换运动的路线不要每天只按同一的固定路线活动，运动中应防止它用鼻子去嗅闻其他小哈所留下的 排泄物或其他物体，更不能让小哈接触，也不要将小哈放到人或其他小哈聚集的场所，以防传染某些疾病。<br />\r\n　　第四，在我们的生活中，尽量不要让狗狗吹空调，这样会导致狗狗拉稀，得空调病，所以做家长的一定注意这方面。<br />\r\n　　第五，每年按时给哈士奇接种疫苗，定期给哈士奇体内外驱虫，当哈士奇发情时，若您还不想很快当&ldquo;爷爷&rdquo;或&ldquo;奶奶&rdquo;应在发情时重点看护她，或者带哈士奇去宠物医院做绝育手术。</span></p>\r\n\r\n<h2>哈士奇喂食要点</h2>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp; <span style=\"font-size:16px\">哈士奇有着敏感的肠胃，因此在饮食上需要主人多加重视，喂食不当很容易<a href=\"http://www.boqii.com/tag/970/\" target=\"_blank\">拉肚子</a>，哪怕是干净健康的食物都有可能导致他腹泻。那么在喂养哈士奇的饮食上要注意什么呢？<br />\r\n　　<strong>喂食要点</strong><br />\r\n　　<strong>适合哈士奇幼犬的食物</strong><br />\r\n　　1.幼犬的食品：如幼犬专用狗粮和罐头。<br />\r\n　　2.钙：补充天然含量高，像超能钙一类的钙产品，促进幼犬的骨骼和牙齿发育。<br />\r\n　　3.幼犬用的奶粉：有专用的幼犬羊奶粉。<br />\r\n　　4.<a href=\"http://www.boqii.com/tag/3313/\" target=\"_blank\">蛋黄</a>：蛋黄的优点是不但含有丰富的蛋白质，而且含有易消化吸收的维生素A、钙质、矿物质。<br />\r\n　　5.维生素矿物质：对于体质较差的幼犬，考虑额外补充一些维生素和矿物质，可以考虑喂食21金维他，也有宠物专用的幼犬金维他。<br />\r\n　　6.肉类：牛、猪、鸡肉等虽然是优良食品，但在喂养幼犬的时候，宜选择不含脂肪的部分，因为脂肪容易变质。但要喂熟的，不要喂生肉！注：4个月前幼犬最好不要过量喂肉食。<br />\r\n　　<strong>喂食用具</strong><br />\r\n　　厚厚的陶瓷盆作为食盆一般不易被狗打破。如果给狗煮肉食，可以任用一种长柄有盖的锅，但是从卫生学的角度看，最好把煮狗食的用具和你厨房中的其他厨具分开使用。当然每餐之后务必要洗净所有的碗和餐具，将剩馀的罐头食品盖上塑胶盖存放妥当。跟人一样，放在冰箱内最多可存放三天，而后吃不完就应丢掉，因为食物里面已经产生了大量肉眼看不见的细菌。<br />\r\n　　<strong>正确饲养</strong><br />\r\n　　犬奶中的成分和牛奶中的不一样，牛奶中的成分有：脂肪，乳糖和蛋白质，虽然犬奶中含的成分也是这些，但是牛奶中的成分相对含量要比犬奶中的低很多，小的狗狗是无法完全吸收牛奶中的成分，而且对肠胃吸收也不是很好，因而会引起腹泻和呕吐的可能。<br />\r\n　　在哈士奇不用再喝犬奶的时候，等到完全断奶了，就可以吃为狗狗设计的狗粮了，狗粮里一般都有狗狗需要的营养了，如果你还想给狗狗加强营养，你可以给狗狗加点蔬菜和水果吃吃，这样营养肯定可以均衡。洋葱、蒜、虾米和一些腌制类的食物是绝对不能给狗狗吃的，这样的东西吃了对它们会有伤害的。尽量不要给狗狗吃一些人吃的东西，人类的肠胃吸收和狗狗的完全不一样，如果狗儿们乱吃东西很有可能对身体造成一定的伤害，如果你疼爱你的<a href=\"http://www.boqii.com/tag/2558/\" target=\"_blank\">小宠</a>物，请一定参照健康的饮食表合理的安排饮食。</span></p>\r\n'),(16,'罗威纳犬','2020-01-27 01:21:11',13,4,'<p>111</p>\r\n'),(17,'博美犬','2020-01-27 01:21:25',9,4,'<p>111</p>\r\n'),(18,'阿拉斯加雪橇犬','2020-01-27 01:21:47',8,4,'<p>111</p>\r\n'),(19,'比熊犬','2020-01-27 01:22:13',10,4,'<p>111</p>\r\n'),(20,'拉布拉多猎犬','2020-01-27 01:22:35',9,4,'<p>111</p>\r\n'),(21,'医院公告1','2020-01-27 01:23:07',7,1,'<p>111</p>\r\n'),(22,'医院公告2','2020-01-27 01:23:14',7,1,'<p>2</p>\r\n'),(23,'医院公告3','2020-01-27 01:23:23',9,1,'<p>33</p>\r\n'),(24,'医院公告4','2020-01-27 01:23:31',7,1,'<p>4</p>\r\n'),(25,'医院公告5','2020-01-27 01:23:45',10,1,'<p>5</p>\r\n'),(26,'医院公告6','2020-01-27 01:26:53',12,1,'<p>6</p>\r\n'),(27,'医院新闻1','2020-01-27 01:27:00',7,2,'<p>1</p>\r\n'),(28,'医院新闻2','2020-01-27 01:27:11',7,2,'<p>2</p>\r\n'),(29,'医院新闻3','2020-01-27 01:27:27',9,2,'<p>3</p>\r\n'),(30,'医院新闻4','2020-01-27 01:27:32',7,2,'<p>4</p>\r\n'),(31,'医院新闻5','2020-01-27 01:27:38',15,2,'<p>5</p>\r\n'),(32,'坚定信心 坚决打赢疫情防控阻击战','2020-01-27 01:27:46',209,2,'<p><strong>央视网消息</strong>（新闻联播）：疫情就是命令，防控就是责任。习近平总书记在1月25日中共中央政治局常务委员会会议上的重要讲话，发出了打赢疫情防控阻击战的战斗号召，在寒冬里为亿万人民带来信心与力量。目前，各地方各部门争分夺秒救治感染患者，强化防控措施落实。广大干部群众众志成城，全力以赴抗击疫情。</p>\r\n\r\n<p>习近平总书记强调，各级党委和政府必须按照党中央决策部署，全面动员，全面部署，全面加强工作，把人民群众生命安全和身体健康放在第一位，把疫情防控工作作为当前最重要的工作来抓。</p>\r\n\r\n<p>今天（1月26日），来自解放军和上海市的医疗专家已进驻武汉市金银潭医院，支援的医疗物资也陆续到位。</p>\r\n\r\n<p style=\"text-align:center\"><img src=\"https://inews.gtimg.com/newsapp_bt/0/11259593956/1000\" /></p>\r\n\r\n<p style=\"text-align:center\"><img src=\"https://inews.gtimg.com/newsapp_bt/0/11259593957/1000\" /></p>\r\n\r\n<p>在这个紧急关头，从医护保障到社区防疫，武汉的广大干部群众齐心协力，抗击疫情。由于武汉公共交通临时停运，奋战在一线的医务工作者出行受到影响。网约车司机组成&ldquo;医护保障车队&rdquo;，免费承担起接送医护人员的任务。</p>\r\n\r\n<p style=\"text-align:center\"><img src=\"https://inews.gtimg.com/newsapp_bt/0/11259593958/1000\" /></p>\r\n\r\n<p>武汉的社区工作者承担着大量社区防疫工作，对于一些确诊病人的家属、密切接触者，社区居委会每天都随时关注他们的情况，并为行动不便的人们送去生活物资。</p>\r\n\r\n<p>为生命接力，全国各地的医护人员紧急动员。从昨晚到今天，来自辽宁、吉林、陕西、山西等地的医疗队整装出发，驰援湖北。</p>\r\n\r\n<p style=\"text-align:center\"><img src=\"https://inews.gtimg.com/newsapp_bt/0/11259593959/1000\" /></p>\r\n\r\n<p>从口罩、防护服到病毒检测试剂盒，各类医用物资也在抓紧生产、星夜驰援。昨天（1月25日）凌晨，由国药器械提供的290多万件疫区急需医用防护用品，运抵武汉，它们将被快速供应给相关医疗、疾控机构使用。河南、福建、浙江等地的医用防护品生产线，这段时间也马力全开，春节不休息。</p>\r\n\r\n<p>山东菏泽、江西南昌等地的铁路部门还专门开通绿色通道，确保物资第一时间运往湖北。</p>\r\n\r\n<p>依法科学有序防控，全国已有30个省份宣布启动重大突发公共卫生事件一级响应，实行最严格的防控措施。</p>\r\n\r\n<p style=\"text-align:center\"><img src=\"https://inews.gtimg.com/newsapp_bt/0/11259593960/1000\" /></p>\r\n\r\n<p>河北省坚持&ldquo;省市县乡村&rdquo;五级联动，对辖区所有居民、返乡人员深入排查。贵州、重庆、安徽等地按照&ldquo;集中患者、集中专家、集中资源、集中救治&rdquo;的原则，全力开展患者救治工作。海南三亚启动24小时工作制度，保障城市公共卫生安全。</p>\r\n'),(33,'宠物饲养1','2020-01-27 01:28:12',24,5,'<p>宠物饲养1</p>\r\n'),(34,'宠物饲养2','2020-01-27 01:28:18',13,5,'<p>宠物饲养2</p>\r\n'),(35,'宠物饲养3','2020-01-27 01:28:23',12,5,'<p>宠物饲养3</p>\r\n'),(36,'宠物饲养4','2020-01-27 01:28:33',15,5,'<p>宠物饲养4</p>\r\n'),(37,'宠物饲养5','2020-01-27 01:28:39',18,5,'<p>宠物饲养5</p>\r\n'),(38,'宠物饲养6','2020-01-27 01:28:44',45,5,'<p>宠物饲养6</p>\r\n'),(39,'法老王猎犬','2020-01-28 01:44:25',8,4,'<p>1</p>\r\n'),(40,'贵宾','2020-01-28 01:44:36',9,4,'<p>1</p>\r\n'),(41,'柴犬','2020-01-28 01:44:58',23,4,'<h1 style=\"margin-left:0px; margin-right:0px; text-align:start\">柴犬</h1>\r\n'),(42,'边境牧羊犬','2020-01-28 01:45:09',20,4,'<h1 style=\"margin-left:0px; margin-right:0px; text-align:start\">边境牧羊犬</h1>\r\n'),(43,'泰迪犬','2020-01-28 01:45:24',15,4,'<h1 style=\"margin-left:0px; margin-right:0px; text-align:start\">泰迪犬</h1>\r\n'),(44,'巴哥犬','2020-01-28 01:45:40',31,4,'<h1 style=\"margin-left:0px; margin-right:0px; text-align:start\">巴哥犬</h1>\r\n'),(45,'杜宾犬','2020-01-28 01:45:52',36,4,'<h1 style=\"margin-left:0px; margin-right:0px; text-align:start\">杜宾犬</h1>\r\n'),(46,'医院公告7','2020-01-28 16:56:15',57,1,'<p>医院公告7</p>\r\n'),(49,'康复故事1','2020-01-28 21:01:07',15,3,'<p>康复故事1</p>\r\n'),(50,'宠物医疗1','2020-01-28 21:17:56',17,6,'<p>宠物医疗1</p>\r\n'),(51,'宠物训练1','2020-01-28 21:18:32',13,7,'<p>宠物训练1</p>\r\n'),(52,'宠物训练2','2020-01-28 21:19:44',8,7,'<p>宠物训练2</p>\r\n'),(53,'康复故事2','2020-01-29 13:26:06',11,3,'<p>康复故事2</p>\r\n'),(54,'康复故事3','2020-01-29 13:26:14',10,3,'<p>康复故事3</p>\r\n'),(55,'康复故事4','2020-01-29 13:26:21',10,3,'<p>康复故事4</p>\r\n'),(56,'康复故事5','2020-01-29 13:26:29',45,3,'<p>康复故事5</p>\r\n');

/*Table structure for table `t_articletype` */

DROP TABLE IF EXISTS `t_articletype`;

CREATE TABLE `t_articletype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_articletype` */

insert  into `t_articletype`(`id`,`name`,`remarks`) values (1,'医院公告','医院公告'),(2,'医院新闻','医院新闻'),(3,'康复故事','康复故事'),(4,'宠物大全','宠物大全'),(5,'宠物饲养','宠物饲养'),(6,'宠物医疗','宠物医疗'),(7,'宠物训练','宠物训练');

/*Table structure for table `t_assay` */

DROP TABLE IF EXISTS `t_assay`;

CREATE TABLE `t_assay` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `petName` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_assay` */

insert  into `t_assay`(`id`,`createDate`,`customerName`,`petName`,`content`) values (4,'2022-05-13 03:07:50','傅丽','小r','111'),(5,'2022-05-13 03:08:11','傅丽','小r','32131');

/*Table structure for table `t_carousel` */

DROP TABLE IF EXISTS `t_carousel`;

CREATE TABLE `t_carousel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imageName` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `t_carousel` */

insert  into `t_carousel`(`id`,`imageName`,`sort`,`remarks`,`type`) values (1,'20200125163059.jpg',1,'1',1),(2,'20200125162410.jpg',2,'1',1),(3,'20200125162501.jpg',3,'1',1),(4,'20200125164544.jpg',4,'1',1),(19,'20200125192437.jpg',5,'1',1),(20,'20200125220628.jpg',1,'2',2),(21,'20200125220635.jpg',2,'2',2),(22,'20200125220613.jpg',3,'2',2),(23,'20200125223719.jpg',4,'2',2);

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsId` int(11) DEFAULT NULL,
  `saleListGoodsId` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `t_comment_ibfk_1` (`customerId`),
  KEY `t_comment_ibfk_2` (`goodsId`),
  CONSTRAINT `t_comment_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_comment_ibfk_2` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

insert  into `t_comment`(`id`,`goodsId`,`saleListGoodsId`,`content`,`createDate`,`customerId`) values (15,37,96,'很棒','2022-05-12 23:34:11',30);

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(300) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT '无',
  `number` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `userName` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `imageName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`id`,`address`,`contact`,`name`,`number`,`remarks`,`userName`,`password`,`imageName`) values (30,'吉林省白山市长白朝鲜族自治县十四道沟镇','蒋杰','LeDao宠物店','19525544875',NULL,'a1203007469','123456','20200501010625.jpg'),(31,'新疆维吾尔自治区塔城地区乌苏市兵团一二五团分部生活区','傅丽','无','18784866199','','823629263','6678696','20220513013511.jpg'),(32,'广西北流市民乐镇民北路120号','赵杰','1','1366565146','1','1203007469','123456','20200528223719.jpg');

/*Table structure for table `t_customer_return_list` */

DROP TABLE IF EXISTS `t_customer_return_list`;

CREATE TABLE `t_customer_return_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amountPaid` float DEFAULT NULL,
  `amountPayable` float DEFAULT NULL,
  `customerReturnDate` datetime DEFAULT NULL,
  `customerReturnNumber` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl0ahdwa8slkocbfe57opembfx` (`customerId`),
  KEY `FKd55ju83f0ntixagdvdrsmw10c` (`userId`),
  CONSTRAINT `FKd55ju83f0ntixagdvdrsmw10c` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKl0ahdwa8slkocbfe57opembfx` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_return_list` */

/*Table structure for table `t_customer_return_list_goods` */

DROP TABLE IF EXISTS `t_customer_return_list_goods`;

CREATE TABLE `t_customer_return_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) NOT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `customerReturnListId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtqt67mbn96lxn8hvtl4piblhi` (`customerReturnListId`),
  KEY `FK4sm5si4swbj3gae46jfk441yx` (`typeId`),
  KEY `t_customer_return_list_goods_ibfk_1` (`goodsId`),
  CONSTRAINT `FKtqt67mbn96lxn8hvtl4piblhi` FOREIGN KEY (`customerReturnListId`) REFERENCES `t_customer_return_list` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_customer_return_list_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_customer_return_list_goods` */

/*Table structure for table `t_damage_list` */

DROP TABLE IF EXISTS `t_damage_list`;

CREATE TABLE `t_damage_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `damageDate` datetime DEFAULT NULL,
  `damageNumber` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpn094ma69sch1icjc2gu7xus` (`userId`),
  CONSTRAINT `FKpn094ma69sch1icjc2gu7xus` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_damage_list` */

/*Table structure for table `t_damage_list_goods` */

DROP TABLE IF EXISTS `t_damage_list_goods`;

CREATE TABLE `t_damage_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `damageListId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbf5m8mm3gctrnuubr9xkjamj8` (`damageListId`),
  KEY `FKdbdfmp09hlf2raktincwroe9n` (`typeId`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `FKbf5m8mm3gctrnuubr9xkjamj8` FOREIGN KEY (`damageListId`) REFERENCES `t_damage_list` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_damage_list_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_damage_list_goods` */

/*Table structure for table `t_equipment` */

DROP TABLE IF EXISTS `t_equipment`;

CREATE TABLE `t_equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `equipmentTypeId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `equipmentTypeId` (`equipmentTypeId`),
  CONSTRAINT `t_equipment_ibfk_1` FOREIGN KEY (`equipmentTypeId`) REFERENCES `t_equipment_type` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_equipment` */

insert  into `t_equipment`(`id`,`name`,`equipmentTypeId`,`status`) values (1,'B超-彩色1号',1,0),(2,'手术心电及血氧监控1',2,0),(3,'生化分析仪1',3,0),(4,'高周波X线机1',7,0),(6,'B超-彩色2号',1,0),(9,'B超-彩色3号',1,0);

/*Table structure for table `t_equipment_type` */

DROP TABLE IF EXISTS `t_equipment_type`;

CREATE TABLE `t_equipment_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `imageName` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_equipment_type` */

insert  into `t_equipment_type`(`id`,`name`,`imageName`,`remarks`) values (1,'B超-彩色','20200128215035.jpg','B超-彩色'),(2,'手术心电及血氧监控','20200126010054.jpg','手术心电及血氧监控'),(3,'生化分析仪','20200126010501.jpg','生化分析仪'),(4,'呼吸麻醉机','20200126010508.jpg','呼吸麻醉机'),(5,'超声波洁牙器','20200126010519.jpg','超声波洁牙器'),(6,'超声骨刀','20200126010532.jpg','超声骨刀'),(7,'高周波X线机','20200126010540.jpg','高周波X线机'),(8,'可磁共振','20200126010547.jpg','可磁共振'),(13,'显微镜','20200126013829.jpg','显微镜'),(14,'血气仪','20200126013953.jpg','血气仪'),(15,'血液细胞分析仪','20200126014528.jpg','血液细胞分析仪'),(16,'B超-黑白','20200126014649.jpg','B超-黑白'),(17,'C型臂','20200126014751.jpg','C型臂'),(18,'OPO骨板系统','20200126014901.jpg','OPO骨板系统'),(19,'DR','20200126015006.jpg','DR'),(20,'PRCL高级锁定骨板系统','20200126015128.jpg','PRCL高级锁定骨板系统');

/*Table structure for table `t_equipmentuselog` */

DROP TABLE IF EXISTS `t_equipmentuselog`;

CREATE TABLE `t_equipmentuselog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beginDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `equipmentId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `equipmentId` (`equipmentId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_equipmentuselog_ibfk_1` FOREIGN KEY (`equipmentId`) REFERENCES `t_equipment` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_equipmentuselog_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_equipmentuselog` */

/*Table structure for table `t_favorite` */

DROP TABLE IF EXISTS `t_favorite`;

CREATE TABLE `t_favorite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `addDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `goodsId` (`goodsId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `t_favorite_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_favorite_ibfk_2` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=286 DEFAULT CHARSET=utf8;

/*Data for the table `t_favorite` */

insert  into `t_favorite`(`id`,`customerId`,`goodsId`,`addDate`) values (285,30,37,'2022-05-12 23:32:52');

/*Table structure for table `t_foster_care` */

DROP TABLE IF EXISTS `t_foster_care`;

CREATE TABLE `t_foster_care` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beginDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `petId` int(11) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `petId` (`petId`),
  CONSTRAINT `t_foster_care_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_foster_care_ibfk_2` FOREIGN KEY (`petId`) REFERENCES `t_pet` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_foster_care` */

insert  into `t_foster_care`(`id`,`beginDate`,`endDate`,`customerId`,`petId`,`price`,`status`,`description`) values (1,'2022-05-13 03:18:14','2022-05-17 03:18:16',31,59,300,0,'12312131'),(2,'2022-05-13 03:18:44','2022-05-16 03:18:47',31,59,211,1,'123131');

/*Table structure for table `t_goods` */

DROP TABLE IF EXISTS `t_goods`;

CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `inventoryQuantity` int(11) DEFAULT NULL,
  `lastPurchasingPrice` float DEFAULT NULL,
  `minNum` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `producer` varchar(200) DEFAULT NULL,
  `purchasingPrice` float DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `sellingPrice` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `details` text,
  `specialPrice` int(11) DEFAULT NULL,
  `isNew` int(11) DEFAULT NULL,
  `hot` int(11) DEFAULT NULL,
  `imageName` varchar(100) DEFAULT NULL,
  `releaseDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxnna5ngumghp4f279mmbjtyo` (`typeId`),
  CONSTRAINT `FKlxnna5ngumghp4f279mmbjtyo` FOREIGN KEY (`typeId`) REFERENCES `t_goodstype` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

/*Data for the table `t_goods` */

insert  into `t_goods`(`id`,`code`,`inventoryQuantity`,`lastPurchasingPrice`,`minNum`,`model`,`name`,`producer`,`purchasingPrice`,`remarks`,`sellingPrice`,`state`,`unit`,`typeId`,`details`,`specialPrice`,`isNew`,`hot`,`imageName`,`releaseDate`) values (1,'0001',7,2100,5,'成年金毛','金毛','张三宠物狗养殖场',2100,'成年金毛',2500,2,'条',33,'<h2>金毛犬品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"金毛犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1406/30/img62691404108661_y.jpg\" style=\"height:350px; width:500px\" title=\"金毛犬的品种简介\" /></p>\r\n\r\n<p>　　金毛巡回猎犬（Golden Retriever），原产于苏格兰，祖先有雪达犬血统，因有较强的游泳能力，并能把猎物从水中叼回给主人，故最初用作狩猎及巡回被枪猎射落的水鸟，AKC分类属于运动犬组。<br />\r\n<strong>　　中文学名：</strong><a href=\"http://www.boqii.com/tag/2024/\" target=\"_blank\">金毛寻回猎犬</a><br />\r\n<strong>　　拉丁学名：</strong>Golden Retriever<br />\r\n<strong>　　别称：</strong>金毛、金毛犬、黄金猎犬<br />\r\n<strong>　　界：</strong>动物界<br />\r\n<strong>　　门：</strong>脊索动物<br />\r\n<strong>　　亚门：</strong><a href=\"http://www.boqii.com/tag/3198/\" target=\"_blank\">脊椎动物</a><br />\r\n<strong>　　纲：</strong><a href=\"http://www.boqii.com/tag/215/\" target=\"_blank\">哺乳</a><br />\r\n<strong>　　亚纲：</strong>哺乳<br />\r\n<strong>　　科：</strong>犬<br />\r\n<strong>　　<a href=\"http://www.boqii.com/tag/5751/\" target=\"_blank\">犬种</a>智商：</strong>排名第 4</p>\r\n',1,0,1,'20200129144157.jpg','2020-01-27 22:12:00'),(2,'0002',8,2600,5,'成年哈士奇','哈士奇','张三宠物狗养殖场',2600,'成年哈士奇',3000,2,'条',33,'<h2>哈士奇品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"哈士奇的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/1/img92451404199301_y.jpg\" style=\"height:350px; width:500px\" title=\"哈士奇的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/355/\" target=\"_blank\">哈士奇</a>(<a href=\"http://www.boqii.com/pet-all/357.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　西伯利亚<a href=\"http://www.boqii.com/tag/3112/\" target=\"_blank\">雪橇犬</a>（Siberian Huskiy)又称为哈士奇，原产于西伯利亚<a href=\"http://www.boqii.com/tag/6316/\" target=\"_blank\">地区</a>，AKC分类属于工作犬组。<a href=\"http://www.boqii.com/tag/2025/\" target=\"_blank\">西伯利亚雪橇犬</a>是东西伯利亚游牧民族伊奴特乔克治族饲养的犬种，长期担任拉雪橇。引导驯鹿及守卫等工作。20世纪初，被毛皮商人带至美国，多年来，一直成为举世闻名的拉雪橇竞赛冠军犬。目前，西伯利亚雪橇犬多被用作伴侣犬。家庭玩赏犬。<br />\r\n　　<strong>中文学名：</strong>西伯利亚雪橇犬<br />\r\n　　<strong>拉丁学名：</strong>Siberian Huskiy<br />\r\n　<strong>　别称：</strong>哈士奇<br />\r\n　　<strong>界：</strong>动物界<br />\r\n　　<strong>门：</strong>动物门<br />\r\n　　<strong>亚门：</strong>脊索椎动物亚门<br />\r\n　　<strong>纲：</strong>哺乳纲<br />\r\n　　<strong>亚纲：</strong>兽亚纲<br />\r\n　<strong>　目：</strong>食肉目<br />\r\n　　<strong>科：</strong>犬科<br />\r\n　<strong>　亚科：</strong>犬亚科<br />\r\n　<strong>　属：</strong>犬属<br />\r\n　<strong>　种：</strong>狼<br />\r\n　<strong>　亚种：</strong>家犬<br />\r\n　<strong>　分布区域：</strong>西伯利亚东北部<br />\r\n<strong>　　原产地：</strong>俄罗斯西伯利亚地区<br />\r\n　<strong>　原始用途：</strong>雪地雪橇犬<br />\r\n<strong>　　今日用途：</strong>伴侣犬、雪橇竞赛犬<br />\r\n　　<strong>体型：</strong><a href=\"http://www.boqii.com/tag/3189/\" target=\"_blank\">中型犬</a></p>\r\n',1,0,1,'20200129144211.jpg','2020-01-27 22:12:07'),(3,'0003',3,8100,5,'成年布偶猫','布偶猫','李四宠物猫养殖场',8100,'成年布偶猫 ',10000,2,'只',34,'<h2>布偶猫品种简介</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"布偶猫品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1406/26/img77111403775285_y.jpg\" title=\"布偶猫品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/398/\" target=\"_blank\">布偶猫</a>(<a href=\"http://www.boqii.com/pet-all/330.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;布偶猫又叫布拉多尔猫、布娃娃猫、玩偶猫，拉丁学名为Ragdoll。虽然布偶猫的体型和体重在整个猫类中都是最大，但它们确是十足的温柔大块头。它们对人类非常友善，即便面对孩子们的打闹也能大度包容，因此布偶猫受到许多家庭的青睐。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;布偶猫的原产地是美国，由家住加州的一名叫Ann Baker的妇女在上世纪60年代所培育，1965年在美国获得认可，然后逐渐进入其他国家。布偶猫进入中国较晚，至今不过10年时间，但布偶猫却在很短时间内就在中国流行开来，这与它们出众的外貌和极佳的性格密不可分。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;如果你喜欢粘人的猫咪，那么布偶猫绝对是一个不错的选择。它们很喜欢待在主人身边，如果你有事在忙，它们也不会吵到你，因为布偶猫的叫声很轻柔，而且大部分情况下，它们都会保持安静。与此同时，布偶猫除了对主人很友善外，它们对陌生人、小孩子和其他动物都非常友好，因此，主人不必担心布偶猫是否会伤害到家作客的客人或其他动物等。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;此外，布偶猫的城市适应能力极强，它们既可以忍受炎炎夏日，也能安然度过数九寒冬。由于布偶猫身上没有体味、不会流口水，所以它们也不会给主人的日常生活带来多少烦恼。而且布偶猫的可训练性也较强，只要主人能够适当引导，它们就会按照指令做出相应的反应。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;不过布偶猫的毛发较长，因此需要主人经常给猫咪梳理毛发，这样不仅可以缓解家中猫毛乱飞的情况，还能让猫咪的毛发更健康！</p>\r\n',1,0,1,'20200129144219.jpg','2020-01-28 22:12:25'),(4,'0004',7,2000,5,'成年猫','中国狸花猫','李四宠物猫养殖场',2000,'中国狸花猫',3000,2,'只',34,'<h2>中国狸花猫品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"中国狸花猫的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/25/img41021406270518_y.jpg\" title=\"中国狸花猫的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/3976/\" target=\"_blank\">中国狸花猫</a>(<a href=\"http://www.boqii.com/pet-all/461.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;中国狸花猫以前被视为难登大雅之堂的<a href=\"http://www.boqii.com/tag/3947/\" target=\"_blank\">土猫</a>，但近年来，许多爱猫人士都致力于中国<a href=\"http://www.boqii.com/tag/181/\" target=\"_blank\">纯种</a>狸花猫的培育，2010年2月8日经过CFA中国长城猫俱乐部六年的努力，CFA终于认可是狸花这一中国本土自然品种。中国长城猫俱乐部为尊重中国人习惯，公布了狸花猫在国际上的<a href=\"http://www.boqii.com/tag/186/\" target=\"_blank\">标准</a><a href=\"http://www.boqii.com/tag/3351/\" target=\"_blank\">名字</a>为：Chinese LiHua。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;中国是狸花猫的源产地，它属于自然猫，因为是在千百年中经过许多品种的自然淘汰而保留下来的品种。中国狸花猫多品种的自然淘汰而保留下来的品种。人们最熟悉的就要算是&ldquo;狸猫换太子&rdquo;（宋朝）的故事了，但中国关于狸花这一品种的介绍却远在此之前。2003CFA中国长城猫俱乐部向国际申请，将中国狸花猫做为中国特有猫种向世界展示，经过七年的努力，于2010年2月8日，CFA休斯顿董事会议上通过。狸花猫正式进入CFA。狸花猫在国际的名称依然延用中国名及发音&ldquo;Chinese Li HUa Mao&rdquo;。从此中国拥有了自己本土的纯种猫。</p>\r\n',1,0,1,'20200129144226.jpg','2020-01-28 22:12:28'),(5,'0005',5,3500,5,'成年猫','波斯猫','李四宠物猫养殖场',3500,'波斯猫',5000,0,'只',34,'<h2>波斯猫品种介绍</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"波斯猫品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/1/img26681404208152_y.jpg\" title=\"波斯猫品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/206/\" target=\"_blank\">波斯猫</a>(<a href=\"http://www.boqii.com/pet-all/364.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;波斯猫，又被人称为波斯、金吉拉或喜马拉雅，拉丁学名为Persian。在人们的印象中，它们的名字就代表着贵族。在中国，大多数人开始饲养宠物猫也是从波斯猫开始。不过大部分饲养者所饲养的波斯猫并非纯种波斯猫，而是一些商家为迎合消费市场所繁育出来的非纯种波斯猫，这点从它们的价格就可以看出来，一般情况下，纯种波斯猫的价格在上千美元。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;跟很多猫咪一样，虽然它们叫波斯猫，但并不是在波斯诞生的一个品种。波斯猫起源于波斯（伊朗），是人们以阿富汗土种<a href=\"http://www.boqii.com/tag/599/\" target=\"_blank\">长毛猫</a>和土耳其或亚美尼亚地区的安哥拉长毛猫为基础、在英国经过100多年的选育繁殖而诞生的一个品种。据说维多利亚女王养了两只蓝色波斯猫，威尔士王子(爱德华七世)在猫展上对其大为褒奖，从此波斯猫的名声越来越大，公众也由此而为之倾慕。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;CFA将波斯猫依毛色分布方式细分成7子种：Solid Color、Silver &amp; Golden、Shaded &amp; Smoke、Tabby、Parti-Color、Calico &amp; Bi-Color、Himalayan。GCCF将波斯猫依毛色分布方式细分成12子种：Bi-Colour、Cameo、Chinchilla、Colourpoint、Exotic（Short haired, Persian type）、Golden、Pewter、Self、Shaded Silver、Smoke、Tortie Tabby、Tortie &amp; White。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;波斯猫在全球各地都有分布，虽然受到布偶猫、异国<a href=\"http://www.boqii.com/tag/265/\" target=\"_blank\">短毛猫</a>、折耳猫等新晋猫咪来势汹汹的冲击，但波斯猫&ldquo;最受宠主欢迎猫咪&rdquo;的地位并未被动摇，这也足以说明波斯猫的魅力有多大。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp;&nbsp;<strong>关于波斯猫认识的一个误区</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;很多人认为波斯猫的眼睛颜色一定是不一样的，事实却不是这样的，一般认为<a href=\"http://www.boqii.com/tag/7834/\" target=\"_blank\">波斯猫眼睛</a>的颜色除了最被人们熟悉的蓝色外，还有琥珀色、绿色、紫铜色、金色、怪色和两只眼睛具有不同颜色(鸳鸯眼)。</p>\r\n',1,0,1,'20200129144530.jpg','2020-01-28 22:12:32'),(6,'0006',10,3000,5,'成年狗','柴犬','张三宠物狗养殖场',3000,'柴犬\r\n',5000,2,'条',33,'<h2>柴犬的种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"柴犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/11/img16931405063212_y.jpg\" style=\"height:350px; width:500px\" title=\"柴犬的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/239/\" target=\"_blank\">柴犬</a>(<a href=\"http://www.boqii.com/pet-all/613.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　柴犬（Shiba Inu），原产地日本，是日本本土中体型最小并且最古老的犬种，日文中意即&ldquo;<a href=\"http://www.boqii.com/tag/5145/\" target=\"_blank\">灌木丛</a>狗&rdquo;，柴犬最初是用来狩猎大型猎物的，但是现在他们用于狩猎较小的动物。在日本的城市、郊区和乡村都可看到柴犬。<br />\r\n　　<strong>中文学名：</strong>日本柴犬<br />\r\n　　<strong>拉丁学名：</strong>Shiba inu</p>\r\n\r\n<p>　　<strong>日语学名：</strong>しばいぬ、しばけん<br />\r\n　　<strong>界：</strong>动物界<br />\r\n　　<strong>门：</strong>脊索动物门<br />\r\n　　<strong>亚门：</strong><a href=\"http://www.boqii.com/tag/3198/\" target=\"_blank\">脊椎动物</a>亚门<br />\r\n　<strong>　纲：</strong>哺乳纲<br />\r\n　　<strong>亚纲：</strong>真兽亚纲<br />\r\n　<strong>　目：</strong>食肉目<br />\r\n　　<strong>亚目：</strong>犬形亚目<br />\r\n<strong>　　科：</strong>犬科<br />\r\n　<strong>　亚科：</strong>犬形亚科<br />\r\n　　<strong>属：</strong>犬属<br />\r\n　<strong>　分布区域：</strong>日本<br />\r\n　<strong>　原产地：</strong>日本<br />\r\n　　<strong>体型：</strong>中型<br />\r\n　<strong>　用途：</strong>工作犬、<a href=\"http://www.boqii.com/tag/6274/\" target=\"_blank\">伴侣犬</a><br />\r\n　<strong>　FCI编号：</strong>257<br />\r\n　　<strong>FCI所属组别：</strong>尖嘴犬和原始犬种组</p>\r\n',1,0,1,'20200129144239.jpg','2020-01-28 22:12:34'),(7,'0007',4,5000,5,'成年猫','英国短毛猫','李四宠物猫养殖场',5000,'英国短毛猫',6500,1,'只',34,'<h2>英国短毛猫品种介绍</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"英国短毛猫的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/25/img1011406259105_y.jpg\" title=\"英国短毛猫的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/295/\" target=\"_blank\">英国短毛猫</a>(<a href=\"http://www.boqii.com/pet-all/458.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;英国短毛猫有悠久的历史，但直到20世纪初才引起人们的宠爱。该猫体形圆胖，外型 由中型至大型。其骨架及肌肉很发达，短而肥的颈与及阔而平的肩膊相配合。头部圆而阔， 体粗短发达，被毛短而密，头大脸圆，大而圆的眼睛根据被毛不同而呈现各种颜色。最大的<a href=\"http://www.boqii.com/tag/3047/\" target=\"_blank\">特征</a>是支耳的距离很接近身。该猫温柔平静，对人友善，很容易<a href=\"http://www.boqii.com/tag/142/\" target=\"_blank\">饲养</a>。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;英国短毛猫的祖先们可以说是&ldquo;战功赫赫&rdquo;，早在2000多年前的古罗马帝国时期，它们就曾跟随凯撒大帝到处征战。在战争中，它们靠着超强的捕鼠能力，保护罗马大军的粮草不被老鼠偷吃，充分保障了军需后方的稳定。从此，这些猫在人们心中得到了很高的地位。就在那个时候，它们被带到了英国境内，靠着极强的适应能力，逐渐演变成为英国的土著猫。它不仅被公认为捕鼠高手，那英俊外形也被更多人所喜爱。</p>\r\n\r\n<p>　　 &nbsp;到了19世纪的末期，英国的育种专家们在这些土著猫中选出最美丽的猫咪，开始了漫长的培育工作，最终这个被称为英国短毛猫的<a href=\"http://www.boqii.com/tag/3974/\" target=\"_blank\">品种</a>诞生了。1871年，英国短毛猫参加了伦敦的水晶宫博览会，起品种也从此开始被命名。1901年，英国猫俱乐部成立了，那时的英国短毛猫还是<a href=\"http://www.boqii.com/tag/3060/\" target=\"_blank\">体型</a>大而结实的蓝色毛种，很像法国的卡尔特猫，后来由于它们的后代越来越像，甚至不分彼此。所以FIFE(英国最大爱猫协会)决定将这两个品种合二为一。第二次世界大战之后，更多毛色的英国短毛猫也陆续被各国的猫会所承认，它们走进了千家万户，成为人们生活中的伴侣。</p>\r\n',1,0,1,'20200129145033.jpg','2020-01-28 22:12:37'),(8,'0008',0,5000,5,'成年猫','美国短毛猫','李四宠物猫养殖场',5000,'美国短毛猫',7000,0,'只',34,'<h2>美国短毛猫品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"美国短毛猫的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/15/img59161405417540_y.jpg\" title=\"美国短毛猫的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/911/\" target=\"_blank\">美国短毛猫</a></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;在猫的种类中，美国短毛猫大受猫友欢迎。它憨厚的外表足以让我们有把它带回家的冲动，下面我们就来说说美国短毛的品种以及价格和如何购买美国短毛猫。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>一、美国短毛猫的品种介绍及起源</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;美国短毛猫的祖先原本生活在欧洲，后来跟随早期的开拓者进入北美洲。有纪录显示在&ldquo;5月花号&rdquo;上饲养了几只猫，它们的职责就是捕捉船上那些偷食物及传播病菌的老鼠。经过不断的繁殖，最终建立了土生的北美洲短毛猫。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;在二十世纪初，由于有一些外国的猫品种被介绍到美国，美国短毛猫的土生血统便开始被削弱，与长毛猫及暹罗猫交配后所得的小猫，有着多种不同长度的披毛，身形，颜色及性情。而那些钟情于土生美国短毛猫的人，他们唯有开始选择性地繁殖以保留美国短毛猫的特征，早期的繁殖者成功地获得完美的斑纹，颜色，亦保留了强壮的形态，美丽的面孔及可爱的性格。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;在美国短毛猫繁殖历史上，起初这个猫种被注册为&ldquo;短毛猫&rdquo;，后来又改为&ldquo;短毛家猫&rdquo;，直到1966年才以&ldquo;美国短毛猫&rdquo;名字出现。这个猫种也是CFA在初始做猫猫品种认证时，最先得到人证的五个品种之一。直到今天，美国短毛猫也一直是排名前十大受欢迎的猫种。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>二、美国短毛猫的价格</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;美国短毛猫的价格没有一个具体，因为大家知道这些都是按猫猫的品相、血统、是否纯种来决定的。一般就上海来说，一只赛季的美国短毛猫市场价可达到8000--12000，纯种的也要在5000--7000元，一般的来说，普通的在2000--3000左右，猫友朋友们可以作为参考。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>三、如何购买美国短毛猫</strong></p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;1、</strong>在选购美国短毛猫时，要注意检查美国短毛猫的身体体表是否健康，是否皮肤发红，脱毛的情况；同时还要检查猫咪的眼睛是否清澈明亮，耳朵内部是否干净，肛门是否干净。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;2、</strong>可以用手触摸猫咪的鼻子，看看是否清凉湿润并且有少许的粘液。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;3、</strong>同时，可以给美国短毛猫喂一些食物，以观察猫咪对周围食物的反应和饮食的情况，以此来判断猫咪是否身体健康。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;4、</strong>同样，在挑选美国短毛猫的时候，为了确保自己的利益和选购到纯种健康的美国短毛猫，选购者应该到正规的宠物商店购买，而不能在路边摊随意选购。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;5、</strong>整体来说美国短毛猫脾气温顺，性格活泼，而且对外界的事物充满的好奇和探索的欲望。从美国短毛猫的外型来看，美国短毛猫体格魁伟，骨胳粗壮，肌肉发达，是短毛猫类中大型品种。美国短毛猫有其祖先勇敢和吃苦耐劳的品格。它们性情温和，总是充满耐性，显得非常的和蔼可亲。美国短毛猫不会对家人乱发脾气。</p>\r\n',1,0,1,'20200129145302.jpg','2020-01-28 22:12:39'),(9,'0009',0,3500,3,'成年猫','异国短毛猫','李四宠物猫养殖场',3500,'异国短毛猫',5500,0,'只',34,'<h2>异国短毛猫品种简介</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"异国短毛猫（加菲猫）品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/17/img8791405582269_y.jpg\" title=\"异国短毛猫（加菲猫）品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/15363/\" target=\"_blank\">异国短毛猫（加菲猫）</a>&nbsp;<a href=\"http://www.boqii.com/tag/15362/\" target=\"_blank\">异国短毛猫（加菲猫）</a>&nbsp;<a href=\"http://www.boqii.com/tag/15361/\" target=\"_blank\">异国短毛猫（加菲猫）</a></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;大家喜欢叫它加菲猫，憨憨的样子极其可爱。加菲猫(Garfield)是由吉姆&middot;戴维斯(Jim Davis)所创，第一次出现在美国报纸上是在1978年6月19日。它是一只爱说风凉话、好吃、爱睡觉，以及爱捉弄人的大肥猫。无论成人还是孩子都被它的魅力所倾倒。 &nbsp; &nbsp; &nbsp; &nbsp;</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>异国短毛猫（加菲猫）起源</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;异国短毛猫（加菲猫）是在六十年代的美国，以人工方式将波斯猫等长毛种的猫与美国短毛猫、缅甸猫等交配繁殖出来的品种。当初进行繁殖计划时，异国短毛猫的体形还很瘦弱，波斯猫的饲养者担心纯种波斯会被杂种化，有些繁殖者甚至强烈批评它&ldquo;有损纯种猫&rdquo;，因而在1968年禁止交配。当然，还是有人暗暗努力，最后发现用美国短毛猫配种，形体才渐渐成型。直到八十年代，异国短毛猫的品种正式确立，并获得猫协会的认可。外来种猫由于经过很多人的反复繁育，毛色品种很多，几乎猫中所有的毛色都有。在外观上基本继承了波斯猫滑稽造型。除了毛短之外，其它体型、四肢、头脸眼均与波斯猫一样。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>异国短毛猫（加菲猫）品种介绍</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;异国短毛猫， 别名: &nbsp;外来种短毛猫、异国短毛猫、短毛波斯猫，又名加菲猫，该猫的历史并不久，大约在1980年才在美国培育成功，并获得猫协会的认可。外来种猫由于经过很多人的反复繁育，毛色品种很多，几乎猫中所有的毛色都有。在外观上基本继承了波斯猫滑稽造型。除了毛短之外，其他体型、四肢、头脸眼均与波斯猫一样。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;异国短毛猫的被毛与美国短毛猫相似，不过却有着像波斯猫一样的矮脚马体形以及大圆脸和扁鼻子。异国短毛猫除拥有浓密被毛外，还保留了波斯猫独特的可爱表情与圆滚滚的体型。性格也如波斯猫般文静、亲切，能慰籍主人的心。体形为中型到大型的短脚型，头部宽而圆，鼻子有明显的凹陷，被毛有柔和的光泽。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;异国短毛猫（加菲猫）购买价格</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;异国短毛猫(加菲猫)的购买价格在上海市场价若纯种的话大概在20000--30000左右，就是一般的加菲猫串串也要在10000左右，如果是自己饲养出生的加菲猫会便宜一点，价格也要在8000左右。</p>\r\n',1,0,0,'20200129145502.jpg','2020-01-28 22:12:50'),(10,'0010',0,500,4,'成年猫','暹罗猫','李四宠物猫养殖场',500,'暹罗猫',1000,0,'只',34,'<h2>暹罗猫品种介绍</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"暹罗猫的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/7/img50111404727569_y.jpg\" title=\"暹罗猫的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/255/\" target=\"_blank\">暹罗猫</a>(<a href=\"http://www.boqii.com/pet-all/359.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;暹罗猫，又叫泰国猫、西母猫，其英文名为Siamese，起源于14世纪，祖先为非<a href=\"http://www.boqii.com/tag/181/\" target=\"_blank\">纯种</a>亚洲猫。虽然科学家手中并没有握着暹罗猫来源的证据，但他们相信暹罗猫是从泰国而来。据记载，暹罗猫早在几百年前就生活在泰国的皇宫和寺庙中，之后它们被作为外交礼物而送给其他国家。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;关于暹罗猫第一次到达亚洲以外的地方，大多数认为是1884年英国驻泰国曼谷领事(1847-1916),从曼谷将一对饲养的暹罗猫Pho和Mia带回英国送给他的姊妹Lilian Jane Veley(以后Veley在1901年也成为了暹罗猫会的创办人之一)。然而翻阅纪录，美国总统莱斯福&middot;凯斯在1878年就收到从曼谷的美国领事馆送来的一只暹罗猫作为礼物。这是第一次有历史记载暹罗猫离开亚洲，比登陆英国还要早了六年，只不过没有繁殖下去而己。1885年 Pho 和Mia 诞下了三只小暹罗猫Duen Ngai，Kalohom 和 Khromata。三只小猫和它们的父母在同年参加于伦敦水晶宫举办的猫展。暹罗猫独特的姿态和举止都带给与会者深刻的印象。不幸地，三只小猫在参展后不久便死了，死因却没有任何的纪录。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;暹罗猫在泰国还被称为Wichien-maat，即&ldquo;月亮钻石&rdquo;的意思，这足以证明当地人对暹罗猫有多重视。据说，过去在泰国皇宫中，暹罗猫还有专人负责起居饮食，即便泰国出现经济危机，它们的生活也完全没有受到任何影响。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;暹罗猫被很多人看作贵族，但跟另外一种猫中贵族波斯猫相比，它们则明显外向得多，它们活泼好动，一听到主人的声音就会立马回应。如果你希望身边有一只机灵的猫咪能打破无聊又平静的生活，那么暹罗猫一定不会让你失望。至于网上有人问，暹罗猫需不需要遛来消耗它们的体力，专家则表示暹罗猫在家的运动就可以满足身体运动的需求，如果担心暹罗猫活动不够，那就每天多陪它们来点游戏吧。</p>\r\n',0,0,1,'20200129145756.jpg','2020-01-29 22:12:55'),(11,'0011',0,2000,4,'成年猫','加拿大无毛猫','李四宠物猫养殖场',2000,'加拿大无毛猫',3000,0,'只',34,'<h2>加拿大无毛猫品种简介</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"加拿大无毛猫品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/17/img49681405590943_y.jpg\" title=\"加拿大无毛猫品种简介\" /></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;加拿大无毛猫又称斯芬克斯猫，英文名为Sphynx，它们来自加拿大，但有记载的无毛猫最先发现于美国，不过发现这种<a href=\"http://www.boqii.com/tag/263/\" target=\"_blank\">猫咪</a>的人并没有它们进行研究和继续培育，反倒是加拿大的猫咪繁育者发现这种猫咪后进行了繁育。其实在世界各地都有无毛猫的存在，因为无毛猫主要是因为基因突变产生的。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;加拿大无毛猫并不是全身光溜溜的一点毛发也没有，在耳部、口部、鼻部、脚部等处都有毛发，但身体的其他部分没有毛发，虽然这种猫咪受到<a href=\"http://www.boqii.com/tag/12684/\" target=\"_blank\">猫毛过敏</a>者但又爱猫的人的喜欢，可还是有很多人无法接受它们皱皱的无毛皮肤。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;尽管加拿大无毛猫并没有一个&ldquo;传统美人&rdquo;的长相，它们的性格却很温顺。它们跟同类相处的时候总是显得非常和谐，只要你看到一次那样的画面，这辈子都不会忘记。此外，加拿大无毛猫与其他猫咪、<a href=\"http://www.boqii.com/tag/332/\" target=\"_blank\">狗狗</a>等动物也能较好地相处，所以它们也很适合成为家庭伴侣宠物。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;最重要的是，加拿大无毛猫的智商很高，如果你以为暹罗猫的智商在猫咪中首屈一指，那么最新的调查报告则会让直到，有一只猫咪比暹罗猫的智商还好，那就是加拿大无毛猫，这意味着主人在训练猫咪的时候会相对轻松，而且主人还可以训练它们掌握一些难度较高的技能。</p>\r\n',0,0,0,'20200129150619.jpg','2020-01-29 22:12:58'),(12,'0012',0,7000,3,'成年猫','苏格兰折耳猫','李四宠物猫养殖场',7000,'苏格兰折耳猫',9000,0,'只',34,'<h2>苏格兰折耳猫品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"苏格兰折耳猫的品种介绍\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/17/img72541405569096_y.jpg\" title=\"苏格兰折耳猫的品种介绍\" /></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;苏格兰折耳猫的耳朵竟是整齐地扣在头上，于是很自然地人们在头脑中把它们划到了精灵族的一边，猫猫中的折耳精灵族非它莫属。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;苏格兰折耳猫品种起源</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;据说在1961年，苏格兰一户牧羊人家里的一只母猫产下了一窝小猫，其中有一只奇怪的小猫，它有着白色的被毛、紧扣着的耳朵和像猫头鹰一样的脸，因为原产地靠近苏格兰的库泊安格斯，从此便根据出生地及耳朵下折的现象，命名这个品种为&ldquo;苏格兰折耳猫&rdquo;。最初的这只猫取名为SUSIE，它便是苏格兰折耳猫的始祖，后来SUSIE又生下了另一只白色折耳猫。这时，牧羊人的邻居，一位叫威廉&middot;罗斯的牧羊人注意到SUSIE有着独一无二的耳朵。于是决定同他的妻子Mary一起，从这一只小猫着手试验，繁殖有折耳特征的新品种。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;苏格兰折耳猫品种介绍</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;苏格兰折耳猫的外观可爱迷人，因此吸引了很多人的兴趣，但滑稽的是，当时它们在国外要比在家乡--英国的苏格兰更见，由于这个品种当时尚未得到猫迷管理委员会的承认，所以英国的培育者对其几乎不感兴趣。1973年这一品种在美国被接纳注册， 1984年才为不列颠<a href=\"http://www.boqii.com/tag/5521/\" target=\"_blank\">猫协会</a>承认，比美国足足晚了11年。突然生出折耳小猫的SUSIE便是苏格兰折耳猫最早的起源。不过 , 这种下折的耳朵实在是少有的突变。正因为过去有生出畸形猫的事情发生，所以有一段时期在英国被禁止繁殖。经过了培育者不断进行慎重的异种交配，终于繁殖出健康的小猫，并且曾在1978年荣获美国爱猫者协会（CFA）冠军。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;苏格兰折耳猫刚出生的时候耳朵并不是折着的。大约三到四周大的时候，它们的耳朵才开始下折&hellip;&hellip;或者就干脆不下折！直到小猫11周到12周大的时候，繁育者才能大致判断出它们的品相（宠物级，繁育级还是赛级）。目前，只有耳朵折下来的折耳猫才能参加比赛，当然，每个繁育者都希望繁育出能参加比赛的猫。但是立耳的折耳猫在繁育过程中的价值却是无价的。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>苏格兰折耳猫的购买和价格</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<a href=\"http://www.boqii.com/tag/1862/\" target=\"_blank\">选购</a>折耳猫时，一定要确认尾巴的弹性，并要检查腿和脚。不能由于腿部粗短或脚趾分开而导致厚重或缺乏弹性。要判断尾巴的弹性可以用手&ldquo;非常轻柔地&rdquo;从尾巴根部略呈拱形向尾梢捋动。如果弹性正常，这种拱形捋动不会给猫带来不适。再次重申，这种动作一定要非常轻柔！</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;苏格兰折耳猫如果品种比较纯的话差不多要5000以上,如果血统相当纯的话就是带有血统证明书的那种得在一万以上了，如果品种不是很纯但是也说的过去的话差不多在2000到3000之间。</p>\r\n',1,0,0,'20200129154739.jpg','2020-01-29 22:13:00'),(13,'0013',0,20000,2,'成年猫','斯芬克斯猫','李四宠物猫养殖场',20000,'斯芬克斯猫',24000,0,'只',34,'<h2>斯芬克斯猫品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"斯芬克斯猫的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/22/img27791406000664_y.jpg\" title=\"斯芬克斯猫的品种简介\" /></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;斯芬克斯猫（Sphynx Cats）又名&ldquo;加拿大无毛猫&rdquo;。是美洲或欧洲的家猫在遗传育种过程中极其稀有的无毛基因变种。尽管斯芬克斯猫体内拥有和家猫相同的皮肤色素，但其表皮仅有少数毛发覆盖。斯芬克斯猫的体型呈楔形，拥有一双大耳朵及臃肿的身体，其头部呈尤达外形。整个外表使得斯芬克斯猫和家猫相比，不但不会给人可爱的感觉，反而让人感到可怕。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>斯芬克斯毛的品种起源</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;有记载的最早无毛猫是一对名叫内利和迪克的同窝出生的兄弟。1903年，美国新墨西哥州人辛尼克从普韦布洛的美国本土印第安人手中买下了它们。1966年，无毛猫再次发现于加拿大多伦多，加拿大无毛猫的名字由此而来。此后不久，在美国的明尼苏达也发现了无毛猫。随着无毛猫的名声越来越大，世界各地也都有发现无毛猫的报道。于是，一些爱猫人士培育出斯芬克斯猫，这种斯芬克斯猫不容易受到基因疾病的侵扰，也不是近亲繁殖所生育的残疾。TlCA承认该品种，此种猫在2005年被认定为稀有品种。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;<strong>斯芬克斯毛的品种介绍</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;斯芬克斯猫又名斯芬克斯无毛猫。早在1700年前就有南美墨西哥土著居民饲养过这种无毛猫的记载。但直到该品种在猫展中获得成功人们才开始注意它，并对它产生兴趣。TlCA承认该品种，此种猫在2005年被认定为稀有品种。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;斯芬克斯猫的购买价格</strong></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;斯芬克斯毛国内并不多见，因为不好养（每天都要<a href=\"http://www.boqii.com/tag/907/\" target=\"_blank\">护理</a>皮肤），喜欢的人也不是很多，价格普遍在20000以上，像一些品相好的或是纯种赛级价格更是高的离谱，在40000以上。</p>\r\n',0,0,0,'20200129155035.jpg','2020-01-29 22:13:02'),(14,'0014',0,2000,3,'成年猫','俄罗斯蓝猫','李四宠物猫养殖场',2000,'俄罗斯蓝猫',3300,0,'只',34,'<h2>俄罗斯蓝猫品种简介</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"俄罗斯蓝猫品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/11/img46311405073374_y.jpg\" title=\"俄罗斯蓝猫品种简介\" /></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;俄罗斯蓝猫，又叫俄国蓝猫、阿契安吉蓝猫、马耳他猫，英文名为Russian Blue，它们也有短毛种之贵族和冬之精灵的美誉。俄罗斯蓝猫起源于19世纪，早前只有在俄罗斯才有，现在则在全球各地都可以看到它们的身影。不仅在国内，即便是在全球，俄罗斯蓝猫的数量都很少，如果想要购买一只俄罗斯蓝猫，至少要准备十来万。如果你看到市面上有号称几千块就能买到的俄罗斯蓝猫，那么这些一定是杂交猫。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;俄罗斯蓝猫的祖先起源于西伯利亚，这也是它们被称为冬天的精灵的原因。一开始俄罗斯蓝猫的祖先从俄罗斯被带去英国，为了保证其种群数量，一些动物繁育者就用暹罗猫与它们杂交，因此俄罗斯蓝猫便跟暹罗猫一样带有了一些东方情调。此外，一些繁育者还培育出一些俄罗斯蓝猫过渡性猫种，但这些过渡性猫种并没有被认可为俄罗斯蓝猫。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;俄罗斯蓝猫引进中国的时间并不短，在1960年代它们便进入中国，俄罗斯蓝猫个性乖巧，又喜欢安静地待在一边，所以它们也得到不少国内爱猫者的喜欢。不过虽然它们很安静，但是它们也很粘人，几乎就是主人走到哪里，它们就会跟到哪里，因此如果你希望有自己的空间，那么俄罗斯蓝猫则不太适合成为你的宠物。如果你不介意脚边一直有个小东西跟着，那么俄罗斯蓝猫一定会成为你贴心的伴侣。</p>\r\n',1,0,0,'20200129215127.jpg','2020-01-29 22:13:04'),(15,'0015',0,3000,3,'成年狗','罗威纳犬','张三宠物狗养殖场',3000,'罗威纳犬',4000,0,'条',33,'<h2>罗威纳犬品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"罗威纳犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/2/img58821404279456_y.jpg\" style=\"height:350px; width:500px\" title=\"罗威纳犬的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/620/\" target=\"_blank\">罗威纳犬</a>(<a href=\"http://www.boqii.com/pet-all/678.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　罗威纳犬（Rottweiler），又称为罗威拿犬，罗纳维德犬，原产于德国，AKC分类属于工作犬组。历史上该犬曾用于帮助人类拖拉物品、打斗、护卫等工作，属于多重用途的大型工作犬种。第一次世界大战时，该犬被作为军犬大量使用于战场，20世纪中期逐步被训练为警用犬。目前，该犬是世界各国最受欢迎的警用犬、军用犬之一，受训后可成为优良的家庭<a href=\"http://www.boqii.com/tag/3182/\" target=\"_blank\">护卫犬</a>。<br />\r\n　　<strong>中文学名：</strong>罗威纳犬<br />\r\n　　<strong>拉丁学名：</strong>Rottweiler<br />\r\n　　<strong>别称：</strong>罗威纳、洛威拿、罗特威勒、罗威<br />\r\n　　<strong>界：</strong>动物界<br />\r\n　　<strong>门：</strong>脊索动物门<br />\r\n<strong>　　亚门：</strong>脊椎动物亚门<br />\r\n　<strong>　纲：</strong>哺乳纲<br />\r\n　　<strong>亚纲：</strong>真兽亚纲<br />\r\n<strong>　　目：</strong>食肉目<br />\r\n　<strong>　亚目：</strong>犬形亚目<br />\r\n　<strong>　科：</strong>犬科<br />\r\n　<strong>　属：</strong>犬属<br />\r\n　<strong>　种：</strong>家犬<br />\r\n　　<strong>亚种：</strong>罗威纳犬<br />\r\n　　<strong>类型：</strong><a href=\"http://www.boqii.com/tag/1595/\" target=\"_blank\">大型犬</a><br />\r\n　<strong>　分类：</strong>畜牧与守卫犬、护卫犬、警犬<br />\r\n<strong>　　身高：</strong>雄：63-69厘米 雌：58-63厘米<br />\r\n　　<strong>体重：</strong>公犬（43-59kg)&nbsp;<a href=\"http://www.boqii.com/tag/356/\" target=\"_blank\">母犬</a>&nbsp;（38-52kg)</p>\r\n',0,0,0,'20200129220137.jpg','2020-01-29 22:13:05'),(16,'0016',0,800,3,'成年狗','博美犬','张三宠物狗养殖场',800,'博美犬',2000,0,'条',33,'<h2>博美犬品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"博美犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1406/26/img42081403772519_y.jpg\" style=\"height:350px; width:500px\" title=\"博美犬的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/467/\" target=\"_blank\">博美犬</a>(<a href=\"http://www.boqii.com/pet-all/347.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　谈及小型玩赏犬及<a href=\"http://www.boqii.com/tag/6274/\" target=\"_blank\">伴侣犬</a>，令人们立刻联想起博美犬，由于博美犬的性格极其外向且活泼可爱，深受广大爱宠人士的喜爱。博美犬原产自德国，属于狐狸犬一种。早期的博美犬体型比较大，而且大多都是白色的毛发。在19世纪以来，经过选拔配种繁育而逐渐发展成为今天小型的犬种。现在的博美犬属于小型玩赏犬种。<br />\r\n　　中文学名：博美犬<br />\r\n　　亚目：犬形亚目<br />\r\n　　拉丁学名：Pomeranian<br />\r\n　　科：犬科<br />\r\n　　别称：波美拉尼亚犬、松鼠犬<br />\r\n　　亚科：犬亚科<br />\r\n　　界：动物界<br />\r\n　　属：犬属<br />\r\n　　门：脊索动物门<br />\r\n　　亚门：<a href=\"http://www.boqii.com/tag/3198/\" target=\"_blank\">脊椎动物</a>亚门<br />\r\n　　纲：哺乳纲<br />\r\n　　亚纲：兽亚纲<br />\r\n　　分布区域：德国<br />\r\n　　目：食肉目<br />\r\n　　类型：小型犬<br />\r\n　　肩高：18-22cm<br />\r\n　　体重：3.5kg以下<br />\r\n　　功能：看守犬、伴侣犬、玩赏犬<br />\r\n　　FCI编号：7</p>\r\n',1,0,0,'20200129220728.jpg','2020-01-29 22:13:07'),(17,'0017',0,2000,3,'成年狗','阿拉斯加雪橇犬','张三宠物狗养殖场',2000,'阿拉斯加雪橇犬',3500,0,'条',33,'<h2>阿拉斯加雪橇犬的品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"阿拉斯加雪橇犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/2/img83441404288988_y.jpg\" style=\"height:350px; width:500px\" title=\"阿拉斯加雪橇犬的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/612/\" target=\"_blank\">阿拉斯加雪橇犬</a>(<a href=\"http://www.boqii.com/pet-all/609.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　阿拉斯加雪橇犬（Alaskan Malamute），又称阿拉斯加马拉穆，是最古老的雪橇犬之一，原产于美国，AKC分类属工作犬组。因它的四肢发达，体格健壮，培育它的目的是为了耐力而不是速度，因而它们的主要用途是拉雪橇。作为宠物，阿拉斯加雪橇犬一旦成熟后有着非常安静、高雅的气质，而且它们忠于主人。<br />\r\n　　<strong>中文学名：</strong>阿拉斯加雪橇犬<br />\r\n　　<strong>拉丁学名：</strong>Alaskan Malamute<br />\r\n<strong>　　别称：</strong>阿拉斯加犬，阿拉斯加马拉缪特，阿拉斯加马拉穆<br />\r\n<strong>　　二名法：</strong>Canis lupus familiaris<br />\r\n　　<strong>界：</strong>动物界<br />\r\n　　<strong>门：</strong>脊椎动物门<br />\r\n　　<strong>亚门：</strong>脊椎动物亚门<br />\r\n　　<strong>纲：</strong>哺乳纲<br />\r\n　<strong>　亚纲：</strong>兽亚纲<br />\r\n　<strong>　目：</strong>肉食目<br />\r\n　　<strong>亚目：</strong>犬型亚目<br />\r\n　<strong>　科：</strong>犬科<br />\r\n　<strong>　亚科：</strong>犬亚科<br />\r\n　　<strong>族：</strong>犬族<br />\r\n　<strong>　属：</strong>犬属<br />\r\n　　<strong>亚属：</strong>犬亚科<br />\r\n　<strong>　种：</strong><a href=\"http://www.boqii.com/tag/3135/\" target=\"_blank\">狼</a>种<br />\r\n　<strong>　亚种：</strong>家犬亚种<br />\r\n　　<strong>关联犬种：</strong>西伯利亚雪橇犬，<a href=\"http://www.boqii.com/tag/384/\" target=\"_blank\">萨摩耶</a>犬<br />\r\n　<strong>　<a href=\"http://www.boqii.com/tag/3060/\" target=\"_blank\">体型</a>：</strong>大型犬<br />\r\n<strong>　　用途：</strong>雪橇犬&nbsp;<a href=\"http://www.boqii.com/tag/13776/\" target=\"_blank\">守卫犬</a>&nbsp;工作犬<br />\r\n　　<strong><a href=\"http://www.boqii.com/tag/2540/\" target=\"_blank\">寿命</a>：</strong>12年~15年</p>\r\n',0,0,1,'20200129222341.jpg','2020-03-19 21:23:41'),(18,'0018',0,980,3,'成年狗','比熊犬','张三宠物狗养殖场',980,'比熊犬',1899,0,'条',33,'<h2>比熊犬品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"比熊犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/1/img81361404204378_y.jpg\" style=\"height:350px; width:500px\" title=\"比熊犬的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/714/\" target=\"_blank\">比熊犬</a>(<a href=\"http://www.boqii.com/pet-all/368.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　比熊犬（Bichon Fris&eacute;）是一种小型常见的宠物狗，1500年，当法国入侵意大利时，法国人被比熊犬白绒绒可爱的样子迷住了，并把它作为战利品带回法国。比熊犬对居住环境的要求很高，经常需要有人陪伴，这点需要特别注意。<br />\r\n　　比熊犬性情温顺、敏感、顽皮又不乏可爱。整体外貌而言，比熊犬体型较小，但身体强壮，活泼可爱，长满蓬松毛发的小尾巴竖在背后，长着一双萌动而又好奇的黑眼睛，它的动作优雅，轻灵惹人欢喜。<br />\r\n　　<strong>中文学名：</strong>比熊犬<br />\r\n　　<strong>拉丁学名：</strong>Bichon Frise<br />\r\n　　<strong>别称：</strong>特内里费狗<br />\r\n　<strong>　纲：</strong>哺乳纲<br />\r\n　　<strong>亚纲：</strong>兽亚纲<br />\r\n　<strong>　目：</strong>食肉目<br />\r\n<strong>　　科：</strong>犬科<br />\r\n　　<strong>亚科：</strong>犬亚科<br />\r\n<strong>　　属：</strong>犬属<br />\r\n<strong>　　种：</strong>犬科<br />\r\n<strong>　　亚种：</strong>家犬<br />\r\n　<strong>　性格特征：</strong>稳重活泼有活力追求自由<br />\r\n<strong>　　犬用途：</strong>伴侣犬、玩赏犬<br />\r\n　　<strong>平均寿命：</strong>12-15岁<br />\r\n　　<strong>适合狗粮：</strong>天然粮、可食粗粮<br />\r\n　　<strong>体高</strong><strong>：</strong>24~29cm<br />\r\n　　<strong>用途</strong><strong>：</strong>伴侣犬<br />\r\n　　<strong>体重</strong><strong>：</strong>3~6公斤</p>\r\n',1,0,1,'20200129222643.jpg','2020-01-29 22:26:43'),(19,'0019',0,1000,3,'成年狗','拉布拉多猎犬','张三宠物狗养殖场',1000,'拉布拉多猎犬',2000,0,'条',33,'<h2>拉布拉多猎犬的品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"拉布拉多猎犬的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1406/30/img13411404099560_y.jpg\" style=\"height:350px; width:500px\" title=\"拉布拉多猎犬的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/7693/\" target=\"_blank\">拉布拉多猎犬</a>(<a href=\"http://www.boqii.com/pet-all/677.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　拉布拉多猎犬（Labrador Retriever），原产于加拿大纽芬兰岛，AKC分类属于运动犬组。根据其祖先是英国猎犬，被当地渔民训练拉网和搬运工作，19世纪流传入英国后又被训练为猎枪犬，现又多被训练为导盲犬和警卫犬，用于侦察毒品和爆炸物。拉布拉多猎犬在犬的智商中排名中一直名列前茅，是目前最受欢迎和最值得信赖的家庭犬。<br />\r\n　　中文学名：拉布拉多猎犬</p>\r\n\r\n<p>　　拉丁学名：labrador retriever<br />\r\n　　别称：拉布拉多、拉不拉多、<a href=\"http://www.boqii.com/tag/16499/\" target=\"_blank\">纽芬兰犬</a>(<a href=\"http://www.boqii.com/pet-all/484.html\" target=\"_blank\">详情介绍</a>)<br />\r\n　　界：动物界<br />\r\n　　门：脊索动物门<br />\r\n　　亚门：脊椎动物亚门<br />\r\n　　纲：哺乳纲<br />\r\n　　亚：纲真兽亚纲<br />\r\n　　目：食肉目<br />\r\n　　亚：目犬形亚目<br />\r\n　　科：犬科<br />\r\n　　亚：科犬形亚科<br />\r\n　　属：犬属<br />\r\n　　种：单猎犬<br />\r\n　　分布区域：加拿大纽芬兰岛<br />\r\n　　体型分类：中型犬<br />\r\n　　个体高度：公<a href=\"http://www.boqii.com/tag/6763/\" target=\"_blank\">狗</a>身高56-62cm、母狗54-59cm<br />\r\n　　一般体重：25-34kg<br />\r\n　　适合<a href=\"http://www.boqii.com/tag/291/\" target=\"_blank\">狗粮</a>：<a href=\"http://www.boqii.com/tag/3297/\" target=\"_blank\">天然粮</a><br />\r\n　　小名：拉拉<br />\r\n　　原产地：加拿大<br />\r\n　　英文名：Labrador</p>\r\n',0,0,1,'20200129222920.jpg','2020-01-29 22:29:20'),(27,'0024',0,30,10,'成年鹦鹉','虎皮鹦鹉','王五鸟类养殖场',30,'虎皮鹦鹉',70,0,'只',57,'<h2>虎皮鹦鹉品种简介</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"虎皮鹦鹉品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1409/17/img99961410945991_y.jpg\" title=\"虎皮鹦鹉品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/681/\" target=\"_blank\">虎皮鹦鹉</a></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;关注鹦鹉的人一定不会对<a href=\"http://www.boqii.com/tag/681/\" target=\"_blank\">虎皮鹦鹉</a>陌生，它们是非常常见的一种鹦鹉，在很多养<a href=\"http://www.boqii.com/tag/4105/\" target=\"_blank\">鸟</a>的家庭中能看到它们。不少人在第一次见到虎皮鹦鹉时可能就会发现，虎皮鹦鹉的叫声并不动听，但这也不是它们的&ldquo;卖点&rdquo;，它们那身十分美丽的羽毛才是让人们产生好感的关键。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;虽然虎皮鹦鹉来自澳大利亚，但它们在全球都很普遍，出现此现象的原因主要有两点&mdash;&mdash;1.虎皮鹦鹉易于照顾和繁殖；2.虎皮鹦鹉变种很多，羽毛鲜艳，很多人会<a href=\"http://www.boqii.com/tag/6324/\" target=\"_blank\">选择</a>它们做宠物。一般情况下，虎皮鹦鹉可活过7岁，如果饲养得当，<a href=\"http://www.boqii.com/tag/2540/\" target=\"_blank\">寿命</a>会延长不少。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;除了虎皮鹦鹉这个名字外，它们还会被唤为背黄青鹦鹉、脊黄青鹦鹉或脊黄青鹦哥。此外，当你听到别人提及娇凤、长尾恋爱鸟、彩凤、石燕、鹦哥、五色小鹦鹉或阿苏儿时，他们指的其实也是虎皮鹦鹉。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;中文学名：</strong>虎皮鹦鹉</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;二名法：</strong>Melopsittacus undulatus</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;界：</strong>动物界</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;门：</strong>脊索动物门</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;亚门：</strong>脊椎动物亚门</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;纲：</strong>鸟纲</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;亚纲：</strong>今鸟亚纲</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;目：</strong>鹦形目</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;科：</strong>鹦鹉科</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;亚科：</strong>鹦鹉亚科</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;族：</strong>玫瑰鹦鹉族</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;属：</strong>虎皮鹦鹉属</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;种：</strong>虎皮鹦鹉</p>\r\n',1,0,1,'20200130002017.jpg','2020-01-30 00:20:17'),(28,'0025',0,50,10,'成年兔','垂耳兔','赵六兔子养殖场',50,'垂耳兔',120,0,'只',57,'<h2>垂耳兔品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"垂耳兔的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/17/img96091405577479_y.jpg\" title=\"垂耳兔的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/396/\" target=\"_blank\">垂耳兔</a>(<a href=\"http://www.boqii.com/pet-all/358.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>垂耳兔是现今最受人们欢迎的<a href=\"http://www.boqii.com/tag/326/\" target=\"_blank\">宠物</a>兔品种，不同于其他兔子，垂耳兔的耳朵是向下垂的，并且体型也并不会很大，性格温顺，能与人类生活的很融洽，缺点就是寿命很短暂，一般寿命在7~8岁。</p>\r\n\r\n<p>垂耳兔是20世纪70年代发现的，在1980年美国兔子繁殖者协会（ARBA）展会中，才获得公认的新品种。这类品种的兔子的耳朵下垂，从外观来看有短毛、中毛、长毛之分，脸型也有所区别。成年体重2.5kg，体长40cm左右。个体的大小，毛色，体长等与其他兔子各不相同。欧洲有多种垂耳兔，&ldquo;垂耳兔&rdquo;是它们的通称。</p>\r\n\r\n<p><strong>中文学名：</strong>垂耳兔</p>\r\n\r\n<p><strong>别称：</strong>宾尼兔、小型垂耳兔、侏儒垂耳兔</p>\r\n\r\n<p><strong>界：</strong>动物界</p>\r\n\r\n<p><strong>门：</strong>脊椎动物门</p>\r\n\r\n<p><strong>纲：</strong>哺乳纲</p>\r\n\r\n<p><strong>目：</strong>兔形目</p>\r\n\r\n<p><strong>科：</strong>兔科</p>\r\n\r\n<p><strong>属：</strong>兔属</p>\r\n\r\n<p><strong>性格特征：</strong>胆小怕惊，喜欢安静，耐寒怕热</p>\r\n\r\n<p><strong>繁殖方式：</strong>胎生</p>\r\n\r\n<p><strong>价格：</strong>垂耳兔的价格并不贵，通常在80~150元左右。</p>\r\n',0,0,0,'20200131013351.jpg','2020-01-31 01:33:51'),(29,'0026',0,300,6,'成年兔','安哥拉兔','赵六兔子养殖场',300,'安哥拉兔',500,0,'只',57,'<h2>安哥拉兔品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"安哥拉兔的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/17/img73451405586173_y.jpg\" title=\"安哥拉兔的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/1753/\" target=\"_blank\">安哥拉兔</a>(<a href=\"http://www.boqii.com/pet-all/365.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>安哥拉兔就是网络上很红的草泥兔，其实这是一个很普通的毛用兔品种，产毛量大且价格不昂贵，所以草泥兔并不像羊驼那样稀缺，相反，养殖安哥拉兔的<a href=\"http://www.boqii.com/tag/142/\" target=\"_blank\">饲养</a>场在国内有很多。现在，人们越来越喜欢毛茸茸的宠物，所以安哥拉兔也走进了普通家庭，最为宠物饲养。</p>\r\n\r\n<p>安哥拉兔源于土耳其的安卡拉省，安卡拉旧时西方称为安哥拉（Angora），1930年应土耳其邮政法的要求改称土耳其语名&ldquo;安卡拉&rdquo;。因其毛细长，有点像安哥拉山羊及安哥拉<a href=\"http://www.boqii.com/tag/1074/\" target=\"_blank\">猫</a>，故名为安哥拉兔。因法国王室在18世纪中期将其作为宠物，因此而该世纪末在欧洲流行。</p>\r\n\r\n<p><strong>中文学名：</strong>安哥拉兔</p>\r\n\r\n<p><strong>二名法：</strong>Angora</p>\r\n\r\n<p><strong>界：</strong>动物界</p>\r\n\r\n<p><strong>门：</strong>脊索动物门</p>\r\n\r\n<p><strong>纲：</strong><a href=\"http://www.boqii.com/tag/215/\" target=\"_blank\">哺乳</a>纲</p>\r\n\r\n<p><strong>目：</strong>兔形目</p>\r\n\r\n<p><strong>科：</strong>兔科</p>\r\n\r\n<p><strong>分布区域：</strong>源于土耳其的安哥拉省</p>\r\n\r\n<p><strong>分类：</strong>安哥拉兔大致上可分为五种：Enland（英国安哥拉），French（法国安哥拉），German（德国安哥拉），Satin Angora（缎毛安哥拉）与&nbsp;Giant Angora（巨型安哥拉）。</p>\r\n\r\n<p><strong>价格：</strong>安哥拉兔的价格并不贵且变化幅度较大，一般在300~500元左右，一些可以达到800元。</p>\r\n',0,0,0,'20200131013702.jpg','2020-01-31 01:37:02'),(30,'0027',0,200,6,'成年鹦鹉','小葵花凤头鹦鹉','王五鸟类养殖场',200,'小葵花凤头鹦鹉',400,0,'只',57,'<h2>小葵花凤头鹦鹉品种简介</h2>\r\n\r\n<p>&nbsp;</p>\r\n\r\n<p style=\"text-align:center\"><img alt=\"小葵花凤头鹦鹉品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1408/13/img13291407923450_y.jpg\" title=\"小葵花凤头鹦鹉品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/18365/\" target=\"_blank\">小葵花凤头鹦鹉</a></p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;小葵花凤头鹦鹉极具特色的外表能让它们从众多鸟儿中脱颖而出，不过也因为相貌出众，它们遭到人们的肆意捕捉。一般在城市中，我们不太会见到有很多人饲养它们，但是如果你欣赏过马戏团的表演，你可能就会发现它们也可以成为一名优秀的演员。由于数量锐减，目前小葵花凤头鹦鹉已被列为极危物种。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;小葵花凤头鹦鹉并没有在世界各地都有分布，除了澳大利亚和印尼外，其他地方的小葵花凤头鹦鹉多为引进的。跟很多鸟类一样，小葵花凤头鹦鹉多以昆虫、<a href=\"http://www.boqii.com/tag/557/\" target=\"_blank\">植物</a>种子和植物果实为食。有时它们甚至会在农田或者果园等地寻找<a href=\"http://www.boqii.com/tag/1219/\" target=\"_blank\">食物</a>，人们看到后会对它们进行驱赶或捕杀。</p>\r\n\r\n<p>&nbsp; &nbsp; &nbsp; &nbsp;小葵花凤头鹦鹉的英文名为Sulphur-crested Cockatoo，它们也有别称，小巴、小巴丹鹦鹉、<a href=\"http://www.boqii.com/tag/10411/\" target=\"_blank\">葵花鹦鹉</a>指的都是小葵花凤头鹦鹉。</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;中文学名：</strong>小葵花凤头鹦鹉</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;二名法：</strong>Cacatua sulphurea</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;界：</strong>动物界</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;门：</strong>脊索动物门</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;亚门：</strong><a href=\"http://www.boqii.com/tag/3198/\" target=\"_blank\">脊椎动物</a>亚门</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;纲：</strong>鸟纲</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;亚纲：</strong>今鸟亚纲</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;目：</strong>鹦形目</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;科：</strong>鹦鹉科</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;亚科：</strong>凤头鹦鹉亚科</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;属：</strong>凤头鹦鹉属</p>\r\n\r\n<p><strong>&nbsp; &nbsp; &nbsp; &nbsp;种：</strong>小葵花凤头鹦鹉</p>\r\n',1,0,1,'20200131014002.jpg','2020-01-31 01:39:45'),(31,'0028',0,100,6,'成年仓鼠','布丁仓鼠','小明仓鼠养殖场',100,'布丁仓鼠',300,0,'只',57,'<h2>布丁仓鼠品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"布丁仓鼠的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1407/17/img38881405565549_y.jpg\" style=\"height:500px; width:500px\" title=\"布丁仓鼠的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/15267/\" target=\"_blank\">布丁仓鼠</a>(<a href=\"http://www.boqii.com/pet-all/360.html\" target=\"_blank\">详情介绍</a>)</p>\r\n\r\n<p>　　布丁仓鼠，别称腮鼠、搬仓鼠、葵鼠，拉丁学名Cricetidae。布丁仓鼠在<a href=\"http://www.boqii.com/tag/1606/\" target=\"_blank\">宠物市场</a>上属于比较常见的品种，由于布丁仓鼠的体色为黄色，而且非常像布丁的那种黄色，所以称为布丁仓鼠，非常受鼠友们的喜爱。</p>\r\n\r\n<p><strong>　　门：</strong>脊索动物门</p>\r\n\r\n<p>　<strong>　目：</strong>啮齿目</p>\r\n\r\n<p>　<strong>　属：</strong>短耳仓鼠属</p>\r\n\r\n<p>　<strong>　界：</strong>动物界</p>\r\n\r\n<p>　　<strong>纲：</strong><a href=\"http://www.boqii.com/tag/215/\" target=\"_blank\">哺乳</a>纲</p>\r\n\r\n<p>　　<strong>科：</strong>仓鼠科</p>\r\n',1,0,1,'20200131014414.jpg','2020-01-31 01:44:14'),(32,'0029',0,20,8,'成年八哥','八哥鸟','王五鸟类养殖场',20,'八哥鸟',100,0,'只',57,'<h2>八哥鸟品种简介</h2>\r\n\r\n<p style=\"text-align:center\"><img alt=\"八哥鸟的品种简介\" src=\"http://img.boqiicdn.com/Data/BK/A/1406/26/img74601403769501_y.jpg\" style=\"height:331px; width:500px\" title=\"八哥鸟的品种简介\" /><br />\r\n<a href=\"http://www.boqii.com/tag/520/\" target=\"_blank\">八哥</a></p>\r\n\r\n<p>　　八哥鸟为中国常见的观赏鸟之一，也是我国独有的观赏鸟之一。自古以来，八哥鸟就是王公贵族们的玩耍之物，有很多文学作品和历史文献中都有提到过八哥鸟。如今，八哥鸟因为非常有灵性，并且通体黑色的外观非常特殊，深受人们的喜爱，将八哥鸟当做宠物鸟来饲养的也越来越多。根据《中国大百科全书》介绍，雄性八哥一般寿命在8~10年左右，雌性八哥一般寿命在10~12年左右。野生八哥一般寿命比笼养的短1~2年！据史书记载，唐朝年间有一大户人家养的一雌性八哥生命力极强，寿命达二十二年。</p>\r\n\r\n<p>　<strong>　中文学名：</strong>八哥</p>\r\n\r\n<p>　<strong>　拉丁学名：</strong>Acridotherescristatellus</p>\r\n\r\n<p><strong>　　别称：</strong>鸲鹆了哥、鹦鹆、寒皋、鸜鹆、驾鸰、加令、凤头八哥</p>\r\n\r\n<p>　<strong>　门：</strong>脊索动物门</p>\r\n\r\n<p><strong>　　亚门：</strong><a href=\"http://www.boqii.com/tag/3198/\" target=\"_blank\">脊椎动物</a>亚门</p>\r\n\r\n<p><strong>　　纲：</strong>鸟纲</p>\r\n\r\n<p>　<strong>　亚纲：</strong>今鸟亚纲</p>\r\n\r\n<p>　<strong>　目：</strong>雀形目</p>\r\n\r\n<p>　<strong>　亚目：</strong>鸣禽亚目</p>\r\n\r\n<p>　<strong>　科：</strong>椋鸟科</p>\r\n\r\n<p>　<strong>　属：</strong>八哥属</p>\r\n\r\n<p>　<strong>　种：</strong>八哥</p>\r\n\r\n<p>　<strong>　分布区域：</strong>陕西南部至长江以南各省，以及台湾和海南省均有分布。</p>\r\n',1,0,1,'20200131014835.jpg','2020-01-31 01:48:36'),(33,'0030',0,55,100,'1kg','法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg','小光狗粮批发',55,'法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg',80,0,'包',36,'<table>\r\n	<tbody>\r\n		<tr>\r\n			<td>商品编号：100151</td>\r\n			<td>商品规格：1KG</td>\r\n			<td>适用对象：怀孕、哺乳期母犬和离乳期幼犬</td>\r\n		</tr>\r\n		<tr>\r\n			<td>颗粒大小：定制三角形</td>\r\n			<td>出厂保质期：18个月</td>\r\n			<td>重量：1.04KG</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n\r\n<p>产品信息<em>Product Information</em></p>\r\n\r\n<p><img alt=\"\" src=\"https://img.boqiicdn.com/Data/Shop/1/146/14683/shopimgFile1426211336.jpg\" /><br />\r\n<br />\r\n法国皇家ROYAL CANIN 奶糕 MIS30</p>\r\n\r\n<p><img src=\"https://img-new.boqiicdn.com/Data/Shop/0/4/487/shoppicpath11568013471_y.jpg?imageView2/2/w/360/h/360/q/100/interlace/0\" style=\"width:340px\" /></p>\r\n\r\n<p>法国皇家ROYAL CANIN所属品牌:</p>\r\n\r\n<p>1kg产品规格:</p>\r\n\r\n<p>怀孕、哺乳期母犬和离乳期幼犬适用犬类:</p>\r\n\r\n<p>产品优势<em>Product Advantage</em></p>\r\n\r\n<p><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573879.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573881.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573882.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573884.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573885.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573886.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573887.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573889.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573890.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573891.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573893.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573894.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573896.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573897.jpg\" /><img alt=\"法国皇家Royal Canin 小型犬幼犬离乳期奶糕粮 1kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/4/487/shopimgFile1569573898.jpg\" /></p>\r\n',0,0,1,'20200202220840.jpg','2020-02-02 22:08:41'),(34,'0031',0,180,60,'3kg','法国皇家Royal Canin 泰迪贵宾专用成犬粮 3kg PD30','小光狗粮批发',180,'法国皇家Royal Canin 泰迪贵宾专用成犬粮 3kg PD30',217,0,'包',36,'<p>法国皇家Royal Canin 泰迪贵宾专用成犬粮 3kg PD30</p>\r\n',1,0,1,'20200202221206.jpg','2020-02-02 22:12:06'),(35,'0032',0,80,100,'2kg','法国皇家Royal Canin 小型成犬粮 2kg','小光狗粮批发',80,'法国皇家Royal Canin 小型成犬粮 2kg',116,0,'包',36,'<p>法国皇家Royal Canin 小型成犬粮 2kg</p>\r\n',0,0,0,'20200202221538.jpg','2020-02-02 22:15:38'),(36,'0033',0,33,200,'1.8kg','宝路Pedigree 牛肉肝蔬菜中小型成犬粮 1.8kg','小光狗粮批发',33,'宝路Pedigree 牛肉肝蔬菜中小型成犬粮 1.8kg',48,0,'包',36,'<p>宝路Pedigree 牛肉肝蔬菜中小型成犬粮 1.8kg</p>\r\n',1,0,1,'20200202222426.jpg','2020-02-02 22:18:08'),(37,'0034',153,26,200,'1.3kg','宝路Pedigree 肉类奶蔬菜幼犬粮 1.3kg','小光狗粮批发',26,'宝路Pedigree 肉类奶蔬菜幼犬粮 1.3kg',40,2,'包',36,'<table>\r\n	<tbody>\r\n		<tr>\r\n			<td>商品编号：101821</td>\r\n			<td>商品规格：1.8kg</td>\r\n			<td>主要原料：鸡肉粉、牛肉粉、谷物</td>\r\n		</tr>\r\n		<tr>\r\n			<td>营养成分：粗蛋白质&ge;25%、粗脂肪&ge;11%、钙&ge;0.8%</td>\r\n			<td>适用对象：7岁以上老年犬</td>\r\n			<td>颗粒大小：标准粒</td>\r\n		</tr>\r\n		<tr>\r\n			<td>口味配方：鸡肉</td>\r\n			<td>出厂保质期：18个月</td>\r\n			<td>重量：1.84KG</td>\r\n		</tr>\r\n	</tbody>\r\n</table>\r\n\r\n<p>产品信息<em>Product Information</em></p>\r\n\r\n<p><img alt=\"\" src=\"https://img.boqiicdn.com/Data/Shop/1/146/14683/shopimgFile1426211336.jpg\" /><br />\r\n<br />\r\n宝路 7岁以上犬粮牛肉鸡肉蔬菜及谷物狗粮</p>\r\n\r\n<p><img src=\"https://img-new.boqiicdn.com/Data/Shop/0/51/5111/shoppicpath11583823345_y.jpg?imageView2/2/w/360/h/360/q/100/interlace/0\" style=\"width:340px\" /></p>\r\n\r\n<p>宝路所属品牌:</p>\r\n\r\n<p>1.8kg产品规格:</p>\r\n\r\n<p>7岁以上老年犬适用犬类:</p>\r\n\r\n<p>宝路大龄犬犬粮，全新升级的宝路大龄犬犬粮，针对大龄犬的特殊营养需求而设计，更易咀嚼的小三角颗粒和更易于消化吸收的专属营养，帮助老朋友们保持健康和年轻活力。5大健康活力表现，是宝路优质营养的好证明。</p>\r\n\r\n<p><img alt=\"\" src=\"https://img.boqiicdn.com/Data/Shop/1/157/15725/shopimgFile1427164141.jpg\" /></p>\r\n\r\n<p>产品优势<em>Product Advantage</em></p>\r\n\r\n<p><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823384.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823386.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823388.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823390.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823391.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823393.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823394.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823396.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823397.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823399.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823401.jpg\" /><img alt=\"宝路Pedigree 牛肉蔬菜口味大龄犬犬粮 1.8kg\" src=\"https://img.boqiicdn.com/Data/Shop/0/51/5111/shopimgFile1583823403.jpg\" /></p>\r\n',0,0,1,'20200202222116.jpg','2020-02-02 22:21:17'),(38,'0035',136,188,100,'8kg','法国皇家Royal Canin A3优选全犬种幼犬粮 8kg','小光狗粮批发',188,'法国皇家Royal Canin A3优选全犬种幼犬粮 8kg',217,2,'包',36,'<p>法国皇家Royal Canin A3优选全犬种幼犬粮 8kg</p>\r\n',1,0,0,'20200202222439.jpg','2020-02-02 22:23:31'),(39,'0036',11,67,200,'1.5kg','伯纳天纯 鸡肉樱桃 小型犬成犬粮 1.5kg','小光狗粮批发',67,'伯纳天纯 鸡肉樱桃 小型犬成犬粮 1.5kg',89,2,'包',36,'<p>伯纳天纯 鸡肉樱桃 小型犬成犬粮 1.5kg</p>\r\n',1,0,1,'20200202222658.jpg','2020-02-02 22:26:59'),(40,'0037',35,33,100,'单片装','拜宠清 犬用体内驱虫 口服 单片装/可三个月喂一次 德国进口','小花宠物医疗用品批发',33,'拜宠清 犬用体内驱虫 口服 单片装/可三个月喂一次 德国进口',47,2,'件',37,'<p>拜宠清 犬用体内驱虫 口服 单片装/可三个月喂一次 德国进口</p>\r\n',1,0,1,'20200202223210.jpg','2020-02-02 22:31:44'),(41,'0038',0,144,100,'整盒3支装','福来恩 犬用体外驱虫滴剂 小型犬10kg以下 整盒3支装/3个月剂量 法国进口','小花宠物医疗用品批发',144,'福来恩 犬用体外驱虫滴剂 小型犬10kg以下 整盒3支装/3个月剂量 法国进口',189,0,'件',37,'<p>福来恩 犬用体外驱虫滴剂 小型犬10kg以下 整盒3支装/3个月剂量 法国进口</p>\r\n',1,0,1,'20200202235646.jpg','2020-02-02 23:56:46'),(42,'0039',11,18,100,'50ml','小宠EHD 洁耳舒 50ml 猫狗预防耳螨耳炎滴耳液','小花宠物医疗用品批发',18,'小宠EHD 洁耳舒 50ml 猫狗预防耳螨耳炎滴耳液',29,2,'件',37,'<p>小宠EHD 洁耳舒 50ml 猫狗预防耳螨耳炎滴耳液</p>\r\n',0,0,0,'20200203000033.jpg','2020-02-03 00:00:34'),(43,'0040',0,23,100,' 单粒/1个','犬心保 犬用体内驱虫 口服 适用11kg以下小型犬 单粒/1个月剂量 美国进口','小花宠物医疗用品批发',23,'犬心保 犬用体内驱虫 口服 适用11kg以下小型犬 单粒/1个月剂量 美国进口',34,0,'盒',37,'<p>犬心保 犬用体内驱虫 口服 适用11kg以下小型犬 单粒/1个月剂量 美国进口</p>\r\n',1,0,1,'20200203000249.jpg','2020-02-03 00:02:49'),(44,'0041',0,150,100,'整盒3支装/3个','福来恩 犬用体外驱虫滴剂 中型犬10-20kg 整盒3支装/3个月剂量 法国进口','小花宠物医疗用品批发',150,'福来恩 犬用体外驱虫滴剂 中型犬10-20kg 整盒3支装/3个月剂量 法国进口',200,0,'盒',37,'<p>福来恩 犬用体外驱虫滴剂 中型犬10-20kg 整盒3支装/3个月剂量 法国进口</p>\r\n',1,0,0,'20200203000452.jpg','2020-02-03 00:04:52'),(45,'0042',9,26,100,'6片装','雷米高Ramical 犬猫体内驱虫 口服驱虫药 6片装 广谱抗虫','小花宠物医疗用品批发',26,'雷米高Ramical 犬猫体内驱虫 口服驱虫药 6片装 广谱抗虫',35,2,'盒',37,'<p>雷米高Ramical 犬猫体内驱虫 口服驱虫药 6片装 广谱抗虫</p>\r\n',0,0,1,'20200203000638.jpg','2020-02-03 00:06:38'),(46,'0043',132,99,100,'100ml','福来恩 犬猫体外驱虫喷剂 100ml 法国进口','小花宠物医疗用品批发',99,'福来恩 犬猫体外驱虫喷剂 100ml 法国进口',128,2,'盒',37,'<p>福来恩 犬猫体外驱虫喷剂 100ml 法国进口</p>\r\n',1,0,0,'20200203000935.jpg','2020-02-03 00:09:35');

/*Table structure for table `t_goodstype` */

DROP TABLE IF EXISTS `t_goodstype`;

CREATE TABLE `t_goodstype` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

/*Data for the table `t_goodstype` */

insert  into `t_goodstype`(`id`,`icon`,`name`,`pId`,`state`) values (1,'icon-folderOpen','所有类别',-1,1),(21,'icon-folder','宠物交易',1,1),(22,'icon-folder','狗狗商品',1,1),(23,'icon-folder','猫咪商品',1,1),(24,'icon-folder','小宠商品',1,1),(25,'icon-folder','水族商品',1,1),(26,'icon-folder','萌宠周边',1,1),(33,'icon-folder','狗狗',21,0),(34,'icon-folder','猫咪',21,0),(36,'icon-folder','主粮零食',22,0),(37,'icon-folder','医疗保健',22,0),(38,'icon-folder','美容日用',22,0),(39,'icon-folder','出行',22,0),(40,'icon-folder','玩具',22,0),(41,'icon-folder','主粮零食',23,0),(42,'icon-folder','医疗保健',23,0),(43,'icon-folder','美容日用',23,0),(44,'icon-folder','出行',23,0),(45,'icon-folder','玩具',23,0),(46,'icon-folder','兔子商品',24,0),(47,'icon-folder','仓鼠商品',24,0),(48,'icon-folder','龙猫商品',24,0),(49,'icon-folder','其它',24,0),(50,'icon-folder','鱼食',25,0),(51,'icon-folder','鱼缸',25,0),(52,'icon-folder','其它',25,0),(53,'icon-folder','布艺',26,0),(54,'icon-folder','装饰',26,0),(55,'icon-folder','家具',26,0),(57,'icon-folder','其它',21,0);

/*Table structure for table `t_goodsunit` */

DROP TABLE IF EXISTS `t_goodsunit`;

CREATE TABLE `t_goodsunit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_goodsunit` */

insert  into `t_goodsunit`(`id`,`name`) values (1,'个'),(2,'袋'),(3,'盒'),(4,'箱'),(5,'台'),(6,'包'),(11,'件'),(12,'条'),(16,'只');

/*Table structure for table `t_information` */

DROP TABLE IF EXISTS `t_information`;

CREATE TABLE `t_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `sendDate` datetime DEFAULT NULL,
  `isRead` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_information_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_information_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_information` */

/*Table structure for table `t_inquiry` */

DROP TABLE IF EXISTS `t_inquiry`;

CREATE TABLE `t_inquiry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `petId` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `imageName` varchar(400) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `reply` varchar(1000) DEFAULT NULL,
  `price` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `petId` (`petId`),
  KEY `customerId` (`customerId`),
  KEY `t_inquiry_ibfk_1` (`userId`),
  CONSTRAINT `t_inquiry_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_inquiry_ibfk_2` FOREIGN KEY (`petId`) REFERENCES `t_pet` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_inquiry_ibfk_3` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_inquiry` */

insert  into `t_inquiry`(`id`,`createDate`,`customerId`,`petId`,`content`,`imageName`,`userId`,`reply`,`price`,`status`) values (1,'2022-05-13 02:02:09',30,3,'123','20220513020209.jpg',NULL,NULL,NULL,0),(2,'2022-05-13 04:35:52',31,59,'123131','20220513043552.jpg',NULL,NULL,NULL,0);

/*Table structure for table `t_log` */

DROP TABLE IF EXISTS `t_log`;

CREATE TABLE `t_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbvn5yabu3vqwvtjoh32i9r4ip` (`userId`),
  CONSTRAINT `FKbvn5yabu3vqwvtjoh32i9r4ip` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13497 DEFAULT CHARSET=utf8;

/*Data for the table `t_log` */

/*Table structure for table `t_medical_record` */

DROP TABLE IF EXISTS `t_medical_record`;

CREATE TABLE `t_medical_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `petName` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_medical_record` */

insert  into `t_medical_record`(`id`,`createDate`,`customerName`,`petName`,`content`) values (1,'2022-05-13 04:11:43','傅丽','小r','21313'),(2,'2022-05-13 04:11:56','傅丽','小r','214141wqewqeq');

/*Table structure for table `t_menu` */

DROP TABLE IF EXISTS `t_menu`;

CREATE TABLE `t_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `icon` varchar(100) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `pId` int(11) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9051 DEFAULT CHARSET=utf8;

/*Data for the table `t_menu` */

insert  into `t_menu`(`id`,`icon`,`name`,`pId`,`state`,`url`) values (1,'menu-plugin','系统菜单',-1,1,NULL),(10,'menu-1','进货管理',1,1,NULL),(20,'menu-2','销售管理',1,1,NULL),(30,'menu-3','库存管理',1,1,NULL),(40,'menu-4','统计报表',1,1,NULL),(50,'menu-5','基础资料',1,1,NULL),(60,'menu-6','预约服务',1,1,NULL),(70,'menu-7','看病服务',1,1,NULL),(90,'menu-9','系统管理',1,1,NULL),(1010,'menu-11','进货入库',10,0,'/purchase/purchase.html'),(1020,'menu-12','退货出库',10,0,'/purchase/return.html'),(1030,'menu-13','进货单据查询',10,0,'/purchase/purchaseSearch.html'),(1040,'menu-14','退货单据查询',10,0,'/purchase/returnSearch.html'),(1050,'menu-15','当前库存查询',10,0,'/common/stockSearch.html'),(2010,'menu-21','销售出库',20,0,'/sale/saleout.html'),(2020,'menu-22','客户退货',20,0,'/sale/salereturn.html'),(2030,'menu-23','销售单据查询',20,0,'/sale/saleSearch.html'),(2040,'menu-24','客户退货查询',20,0,'/sale/returnSearch.html'),(2050,'menu-25','当前库存查询',20,0,'/common/stockSearch.html'),(3010,'menu-31','商品报损',30,0,'/stock/damage.html'),(3020,'menu-32','商品报溢',30,0,'/stock/overflow.html'),(3030,'menu-33','库存报警',30,0,'/stock/alarm.html'),(3040,'menu-34','报损报溢查询',30,0,'/stock/damageOverflowSearch.html'),(3050,'menu-35','当前库存查询',30,0,'/common/stockSearch.html'),(4010,'menu-41','供应商统计',40,0,'/count/supplier.html'),(4020,'menu-42','客户统计',40,0,'/count/customer.html'),(4030,'menu-43','商品采购统计',40,0,'/count/purchase.html'),(4040,'menu-44','商品销售统计',40,0,'/count/sale.html'),(4050,'menu-45','按日统计分析',40,0,'/count/saleDay.html'),(4060,'menu-46','按月统计分析',40,0,'/count/saleMonth.html'),(5010,'menu-51','供应商管理',50,0,'/basicData/supplier.html'),(5020,'menu-52','客户管理',50,0,'/basicData/customer.html'),(5030,'menu-53','商品管理',50,0,'/basicData/goods.html'),(5040,'menu-54','期初库存',50,0,'/basicData/stock.html'),(5050,'menu-55','轮播图管理',50,0,'/basicData/carousel.html'),(5060,'menu-56','设备类型管理',50,0,'/basicData/equipmentType.html'),(5070,'menu-57','写文章',50,0,'/basicData/writeArticle.html'),(5080,'menu-58','文章管理',50,0,'/basicData/articleManage.html'),(5090,'menu-59','文章类型管理',50,0,'/basicData/articleTypeManage.html'),(5091,'menu-591','客户留言管理',50,0,'/basicData/suggestionManage.html'),(5092,'menu-592','设备管理',50,0,'/basicData/equipmentManage.html'),(5093,'menu-593','设备使用管理',50,0,'/basicData/equipmentUseManage.html'),(5094,'menu-594','设备使用记录管理',50,0,'/basicData/equipmentUseLogManage.html'),(5095,'menu-595','医院用品管理',50,0,'/basicData/tackleManage.html'),(5096,'menu-596','医院用品出入库管理',50,0,'/basicData/tackleOutManage.html'),(5097,'menu-597','医院用品出入库记录管理',50,0,'/basicData/tackleOutLogManage.html'),(5098,'menu-598','客户消息管理',50,0,'/basicData/informationManage.html'),(5099,'menu-599','客户订单处理',50,0,'/basicData/orderHandleManage.html'),(5100,'menu-5100','客户支付记录管理',50,0,'/basicData/saleListPaymentInformationManage.html'),(5101,'menu-5101','客户评价管理',50,0,'/basicData/commentManage.html'),(5102,'menu-5102','客户退货申请管理',50,0,'/basicData/returnApplyManage.html'),(6010,'menu-61','我的未预约单(医生)',60,0,'/reservation/listNotHandleDoctor.html'),(6020,'menu-62','我的未预约单(美容师)',60,0,'/reservation/listNotHandleBeautician.html'),(6030,'menu-63','我的已预约单',60,0,'/reservation/myReservation.html'),(6040,'menu-65','我的已结束预约单',60,0,'/reservation/myFinishReservation.html'),(6050,'menu-64','预约单管理',60,0,'/reservation/reservationManage.html'),(7010,'menu-71','网上问诊',70,0,'/inquiry/inquiryReply.html'),(7020,'menu-72','我的问诊',70,0,'/inquiry/myInquiryReply.html'),(7030,'menu-73','问诊记录管理',70,0,'/inquiry/inquiryManage.html'),(7040,'menu-74','病历单管理',70,0,'/basicData/medicalRecordManage.html'),(7050,'menu-75','化验记录管理',70,0,'/basicData/assayManage.html'),(7060,'menu-76','疫苗注射记录管理',70,0,'/basicData/vaccineManage.html'),(7070,'menu-77','客户回访记录管理',70,0,'/basicData/returnVisitManage.html'),(7080,'menu-78','寄养记录管理',70,0,'/basicData/fosterCareManage.html'),(9010,'menu-91','角色管理',90,0,'/power/role.html'),(9020,'menu-92','用户管理',90,0,'/power/user.html'),(9030,'menu-94','系统日志',90,0,'/power/log.html'),(9040,'menu-93','修改密码',90,0,NULL),(9050,'menu-95','安全退出',90,0,NULL);

/*Table structure for table `t_overflow_list` */

DROP TABLE IF EXISTS `t_overflow_list`;

CREATE TABLE `t_overflow_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `overflowDate` datetime DEFAULT NULL,
  `overflowNumber` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3bu8hj2xniqwbrtg6ls6b8ej2` (`userId`),
  CONSTRAINT `FK3bu8hj2xniqwbrtg6ls6b8ej2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_overflow_list` */

/*Table structure for table `t_overflow_list_goods` */

DROP TABLE IF EXISTS `t_overflow_list_goods`;

CREATE TABLE `t_overflow_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `overflowListId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKd3s9761mgl456tn2xb0d164h7` (`overflowListId`),
  KEY `FK8t46iik5kpciki8fnqtiuq5q3` (`typeId`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `FKd3s9761mgl456tn2xb0d164h7` FOREIGN KEY (`overflowListId`) REFERENCES `t_overflow_list` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_overflow_list_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_overflow_list_goods` */

/*Table structure for table `t_pet` */

DROP TABLE IF EXISTS `t_pet`;

CREATE TABLE `t_pet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `typeName` varchar(100) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `imageName` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `t_pet_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8;

/*Data for the table `t_pet` */

insert  into `t_pet`(`id`,`name`,`typeName`,`customerId`,`age`,`imageName`) values (3,'小y','金毛',30,3,'20200202184514.jpg'),(59,'小r','猫咪',31,2,'20220513013734.jpg');

/*Table structure for table `t_purchase_list` */

DROP TABLE IF EXISTS `t_purchase_list`;

CREATE TABLE `t_purchase_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amountPaid` float DEFAULT NULL,
  `amountPayable` float DEFAULT NULL,
  `purchaseDate` datetime DEFAULT NULL,
  `purchaseNumber` varchar(100) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `supplierId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5j2dev8b2b5d0l69nb8vtr4yb` (`supplierId`),
  KEY `FK69s6eyxr4wwvsywe9hbthef1h` (`userId`),
  CONSTRAINT `FK5j2dev8b2b5d0l69nb8vtr4yb` FOREIGN KEY (`supplierId`) REFERENCES `t_supplier` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK69s6eyxr4wwvsywe9hbthef1h` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_purchase_list` */

/*Table structure for table `t_purchase_list_goods` */

DROP TABLE IF EXISTS `t_purchase_list_goods`;

CREATE TABLE `t_purchase_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` float DEFAULT NULL,
  `price` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `purchaseListId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfvdvgcebqkkokyn0o00idqnpy` (`purchaseListId`),
  KEY `FK83ikbi2x3epn49fwcco8jlfwu` (`typeId`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `FKfvdvgcebqkkokyn0o00idqnpy` FOREIGN KEY (`purchaseListId`) REFERENCES `t_purchase_list` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_purchase_list_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_purchase_list_goods` */

/*Table structure for table `t_reservation` */

DROP TABLE IF EXISTS `t_reservation`;

CREATE TABLE `t_reservation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `petId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `reserveDate` datetime DEFAULT NULL,
  `hour` int(11) DEFAULT NULL,
  `minute` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `isRemind` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `petId` (`petId`),
  KEY `userId` (`userId`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `t_reservation_ibfk_1` FOREIGN KEY (`petId`) REFERENCES `t_pet` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_reservation_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_reservation_ibfk_3` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1702 DEFAULT CHARSET=utf8;

/*Data for the table `t_reservation` */

insert  into `t_reservation`(`id`,`type`,`customerId`,`petId`,`userId`,`createDate`,`reserveDate`,`hour`,`minute`,`description`,`status`,`remarks`,`isRemind`) values (1270,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1271,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1272,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1273,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1274,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1275,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1276,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1277,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1278,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1279,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1280,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1281,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1282,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1283,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1284,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1285,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1286,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1287,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1288,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1289,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1290,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1291,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1292,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1293,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1294,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1295,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1296,'预约医生',NULL,NULL,8,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1297,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1298,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1299,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1300,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1301,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1302,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1303,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1304,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1305,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1306,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1307,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1308,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1309,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1310,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1311,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1312,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1313,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1314,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1315,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1316,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1317,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1318,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1319,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1320,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1321,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1322,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1323,'预约医生',NULL,NULL,9,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1324,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1325,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1326,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1327,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1328,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1329,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1330,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1331,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1332,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1333,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1334,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1335,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1336,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1337,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1338,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1339,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1340,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1341,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1342,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1343,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1344,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1345,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1346,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1347,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1348,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1349,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1350,'预约医生',NULL,NULL,10,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1351,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1352,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1353,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1354,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1355,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1356,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1357,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1358,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1359,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1360,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1361,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1362,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1363,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1364,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1365,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1366,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1367,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1368,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1369,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1370,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1371,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1372,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1373,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1374,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1375,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1376,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1377,'预约医生',NULL,NULL,11,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1378,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1379,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1380,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1381,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1382,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1383,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1384,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1385,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1386,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1387,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1388,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1389,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1390,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1391,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1392,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1393,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1394,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1395,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1396,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1397,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1398,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1399,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1400,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1401,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1402,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1403,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1404,'预约医生',NULL,NULL,12,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1405,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1406,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1407,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1408,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1409,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1410,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1411,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1412,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1413,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1414,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1415,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1416,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1417,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1418,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1419,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1420,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1421,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1422,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1423,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1424,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1425,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1426,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1427,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1428,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1429,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1430,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1431,'预约医生',NULL,NULL,13,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1432,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1433,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1434,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1435,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1436,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1437,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1438,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1439,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1440,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1441,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1442,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1443,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1444,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1445,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1446,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1447,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1448,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1449,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1450,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1451,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1452,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1453,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1454,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1455,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1456,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1457,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1458,'预约医生',NULL,NULL,14,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1459,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 08:00:00',8,0,NULL,0,NULL,0),(1460,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 08:20:00',8,20,NULL,0,NULL,0),(1461,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 08:40:00',8,40,NULL,0,NULL,0),(1462,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 09:00:00',9,0,NULL,0,NULL,0),(1463,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 09:20:00',9,20,NULL,0,NULL,0),(1464,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 09:40:00',9,40,NULL,0,NULL,0),(1465,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 10:00:00',10,0,NULL,0,NULL,0),(1466,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 10:20:00',10,20,NULL,0,NULL,0),(1467,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 10:40:00',10,40,NULL,0,NULL,0),(1468,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 11:00:00',11,0,NULL,0,NULL,0),(1469,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 11:20:00',11,20,NULL,0,NULL,0),(1470,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 11:40:00',11,40,NULL,0,NULL,0),(1471,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 13:00:00',13,0,NULL,0,NULL,0),(1472,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 13:20:00',13,20,NULL,0,NULL,0),(1473,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 13:40:00',13,40,NULL,0,NULL,0),(1474,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 14:00:00',14,0,NULL,0,NULL,0),(1475,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 14:20:00',14,20,NULL,0,NULL,0),(1476,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 14:40:00',14,40,NULL,0,NULL,0),(1477,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 15:00:00',15,0,NULL,0,NULL,0),(1478,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 15:20:00',15,20,NULL,0,NULL,0),(1479,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 15:40:00',15,40,NULL,0,NULL,0),(1480,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 16:00:00',16,0,NULL,0,NULL,0),(1481,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 16:20:00',16,20,NULL,0,NULL,0),(1482,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 16:40:00',16,40,NULL,0,NULL,0),(1483,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 17:00:00',17,0,NULL,0,NULL,0),(1484,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 17:20:00',17,20,NULL,0,NULL,0),(1485,'预约美容师',NULL,NULL,15,'2022-05-12 20:44:00','2022-05-13 17:40:00',17,40,NULL,0,NULL,0),(1486,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1487,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1488,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1489,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1490,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1491,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1492,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1493,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1494,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1495,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1496,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1497,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1498,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1499,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1500,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1501,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1502,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1503,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1504,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1505,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1506,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1507,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1508,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1509,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1510,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1511,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1512,'预约医生',NULL,NULL,8,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1513,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1514,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1515,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1516,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1517,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1518,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1519,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1520,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1521,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1522,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1523,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1524,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1525,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1526,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1527,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1528,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1529,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1530,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1531,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1532,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1533,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1534,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1535,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1536,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1537,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1538,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1539,'预约医生',NULL,NULL,9,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1540,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1541,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1542,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1543,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1544,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1545,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1546,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1547,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1548,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1549,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1550,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1551,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1552,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1553,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1554,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1555,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1556,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1557,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1558,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1559,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1560,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1561,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1562,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1563,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1564,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1565,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1566,'预约医生',NULL,NULL,10,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1567,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1568,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1569,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1570,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1571,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1572,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1573,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1574,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1575,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1576,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1577,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1578,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1579,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1580,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1581,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1582,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1583,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1584,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1585,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1586,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1587,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1588,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1589,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1590,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1591,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1592,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1593,'预约医生',NULL,NULL,11,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1594,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1595,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1596,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1597,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1598,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1599,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1600,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1601,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1602,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1603,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1604,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1605,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1606,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1607,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1608,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1609,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1610,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1611,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1612,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1613,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1614,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1615,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1616,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1617,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1618,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1619,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1620,'预约医生',NULL,NULL,12,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1621,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1622,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1623,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1624,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1625,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1626,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1627,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1628,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1629,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1630,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1631,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1632,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1633,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1634,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1635,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1636,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1637,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1638,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1639,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1640,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1641,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1642,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1643,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1644,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1645,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1646,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1647,'预约医生',NULL,NULL,13,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1648,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1649,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1650,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1651,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1652,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1653,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1654,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1655,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1656,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1657,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1658,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1659,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1660,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1661,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1662,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1663,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1664,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1665,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1666,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1667,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1668,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1669,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1670,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1671,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1672,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1673,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1674,'预约医生',NULL,NULL,14,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0),(1675,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 08:00:00',8,0,NULL,0,NULL,0),(1676,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 08:20:00',8,20,NULL,0,NULL,0),(1677,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 08:40:00',8,40,NULL,0,NULL,0),(1678,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 09:00:00',9,0,NULL,0,NULL,0),(1679,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 09:20:00',9,20,NULL,0,NULL,0),(1680,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 09:40:00',9,40,NULL,0,NULL,0),(1681,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 10:00:00',10,0,NULL,0,NULL,0),(1682,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 10:20:00',10,20,NULL,0,NULL,0),(1683,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 10:40:00',10,40,NULL,0,NULL,0),(1684,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 11:00:00',11,0,NULL,0,NULL,0),(1685,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 11:20:00',11,20,NULL,0,NULL,0),(1686,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 11:40:00',11,40,NULL,0,NULL,0),(1687,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 13:00:00',13,0,NULL,0,NULL,0),(1688,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 13:20:00',13,20,NULL,0,NULL,0),(1689,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 13:40:00',13,40,NULL,0,NULL,0),(1690,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 14:00:00',14,0,NULL,0,NULL,0),(1691,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 14:20:00',14,20,NULL,0,NULL,0),(1692,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 14:40:00',14,40,NULL,0,NULL,0),(1693,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 15:00:00',15,0,NULL,0,NULL,0),(1694,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 15:20:00',15,20,NULL,0,NULL,0),(1695,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 15:40:00',15,40,NULL,0,NULL,0),(1696,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 16:00:00',16,0,NULL,0,NULL,0),(1697,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 16:20:00',16,20,NULL,0,NULL,0),(1698,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 16:40:00',16,40,NULL,0,NULL,0),(1699,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 17:00:00',17,0,NULL,0,NULL,0),(1700,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 17:20:00',17,20,NULL,0,NULL,0),(1701,'预约美容师',NULL,NULL,15,'2022-05-13 00:00:00','2022-05-14 17:40:00',17,40,NULL,0,NULL,0);

/*Table structure for table `t_return_apply` */

DROP TABLE IF EXISTS `t_return_apply`;

CREATE TABLE `t_return_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerId` int(11) DEFAULT NULL,
  `saleListId` int(11) DEFAULT NULL,
  `saleListGoodsId` int(11) DEFAULT NULL,
  `saleListNumber` varchar(200) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `applyDate` datetime DEFAULT NULL,
  `reason` varchar(1000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `saleListGoodsId` (`saleListGoodsId`),
  KEY `saleListId` (`saleListId`),
  CONSTRAINT `t_return_apply_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_return_apply_ibfk_2` FOREIGN KEY (`saleListGoodsId`) REFERENCES `t_sale_list_goods` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_return_apply_ibfk_3` FOREIGN KEY (`saleListId`) REFERENCES `t_sale_list` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_return_apply` */

/*Table structure for table `t_return_list` */

DROP TABLE IF EXISTS `t_return_list`;

CREATE TABLE `t_return_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amountPaid` float NOT NULL,
  `amountPayable` float NOT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `returnDate` datetime DEFAULT NULL,
  `returnNumber` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `supplierId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4qxjj8bvj2etne243xluni0vn` (`supplierId`),
  KEY `FK904juw2v1hm2av0ig26gae9jb` (`userId`),
  CONSTRAINT `FK4qxjj8bvj2etne243xluni0vn` FOREIGN KEY (`supplierId`) REFERENCES `t_supplier` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK904juw2v1hm2av0ig26gae9jb` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_return_list` */

/*Table structure for table `t_return_list_goods` */

DROP TABLE IF EXISTS `t_return_list_goods`;

CREATE TABLE `t_return_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `returnListId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKemclu281vyvyk063c3foafq1w` (`returnListId`),
  KEY `FKa1prpd96fcs0x2oe0omny9vio` (`typeId`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `FKemclu281vyvyk063c3foafq1w` FOREIGN KEY (`returnListId`) REFERENCES `t_return_list` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_return_list_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_return_list_goods` */

/*Table structure for table `t_return_visit` */

DROP TABLE IF EXISTS `t_return_visit`;

CREATE TABLE `t_return_visit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `petName` varchar(100) DEFAULT NULL,
  `satisfaction` int(11) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_return_visit` */

insert  into `t_return_visit`(`id`,`createDate`,`customerName`,`petName`,`satisfaction`,`content`) values (1,'2022-05-13 02:20:21','蒋杰','小y',3,'1231231'),(2,'2022-05-13 02:21:18','傅丽','小r',5,'1232131'),(3,'2022-05-13 02:27:45','傅丽','小r',5,'111');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`name`,`remarks`) values (1,'系统管理员','管理员 最高权限'),(2,'主管','主管'),(4,'采购员','采购员'),(5,'销售经理','销售经理'),(7,'仓库管理员','仓库管理员'),(9,'总经理','总经理'),(10,'医生','医生'),(11,'美容师','美容师'),(12,'设备管理人员','设备管理人员'),(13,'测试','测试');

/*Table structure for table `t_role_menu` */

DROP TABLE IF EXISTS `t_role_menu`;

CREATE TABLE `t_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menuId` int(11) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhayg4ib6v7h1wyeyxhq6xlddq` (`menuId`),
  KEY `FKsonb0rbt2u99hbrqqvv3r0wse` (`roleId`),
  CONSTRAINT `FKsonb0rbt2u99hbrqqvv3r0wse` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_role_menu_ibfk_1` FOREIGN KEY (`menuId`) REFERENCES `t_menu` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=509 DEFAULT CHARSET=utf8;

/*Data for the table `t_role_menu` */

insert  into `t_role_menu`(`id`,`menuId`,`roleId`) values (257,1,1),(258,10,1),(259,1010,1),(260,1020,1),(261,1030,1),(262,1040,1),(263,1050,1),(264,20,1),(265,2010,1),(266,2020,1),(267,2030,1),(268,2040,1),(269,2050,1),(270,30,1),(271,3010,1),(272,3020,1),(273,3030,1),(274,3040,1),(275,3050,1),(276,40,1),(277,4010,1),(278,4020,1),(279,4030,1),(280,4040,1),(281,4050,1),(282,4060,1),(283,50,1),(284,5010,1),(285,5020,1),(286,5030,1),(287,5040,1),(288,5050,1),(289,5060,1),(290,5070,1),(291,5080,1),(292,5090,1),(293,5091,1),(294,60,1),(295,6050,1),(296,90,1),(297,9010,1),(298,9020,1),(299,9030,1),(300,9040,1),(301,9050,1),(302,70,1),(305,7030,1),(317,7040,1),(318,7050,1),(319,7060,1),(320,7070,1),(321,7080,1),(322,5092,1),(323,5093,1),(324,5094,1),(325,5095,1),(326,5096,1),(327,5097,1),(328,5098,1),(329,5099,1),(335,5100,1),(336,5101,1),(356,5102,1),(393,1,2),(394,10,2),(395,1010,2),(396,1020,2),(397,1030,2),(398,1040,2),(399,1050,2),(400,90,2),(401,9040,2),(402,9050,2),(403,1,4),(404,20,4),(405,2010,4),(406,90,4),(407,9040,4),(408,9050,4),(422,1,7),(423,10,7),(424,1010,7),(425,1020,7),(426,1030,7),(427,1040,7),(428,1050,7),(429,20,7),(430,2010,7),(431,2020,7),(432,2030,7),(433,40,7),(434,4010,7),(435,4020,7),(436,90,7),(437,9040,7),(438,9050,7),(439,1,9),(440,30,9),(441,3040,9),(442,3050,9),(443,50,9),(444,5010,9),(445,5020,9),(446,5030,9),(447,5040,9),(448,90,9),(449,9040,9),(450,9050,9),(451,1,10),(452,60,10),(453,6010,10),(454,6030,10),(455,6040,10),(456,70,10),(457,7010,10),(458,7020,10),(459,90,10),(460,9040,10),(461,9050,10),(462,1,11),(463,60,11),(464,6020,11),(465,6030,11),(466,6040,11),(467,90,11),(468,9040,11),(469,9050,11),(470,1,12),(471,50,12),(472,5092,12),(473,5093,12),(474,5094,12),(475,90,12),(476,9040,12),(477,9050,12),(478,1,5),(479,20,5),(480,2010,5),(481,2020,5),(482,2030,5),(483,2040,5),(484,2050,5),(485,30,5),(486,3010,5),(487,90,5),(488,9040,5),(489,9050,5),(505,1,13),(506,90,13),(507,9040,13),(508,9050,13);

/*Table structure for table `t_sale_list` */

DROP TABLE IF EXISTS `t_sale_list`;

CREATE TABLE `t_sale_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amountPaid` float DEFAULT NULL,
  `amountPayable` float DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `saleDate` datetime DEFAULT NULL,
  `saleNumber` varchar(100) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKox4qfs87eu3fvwdmrvelqhi8e` (`customerId`),
  KEY `FK34bnujemrdqimbhg133enp8k8` (`userId`),
  CONSTRAINT `FK34bnujemrdqimbhg133enp8k8` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKox4qfs87eu3fvwdmrvelqhi8e` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=utf8;

/*Data for the table `t_sale_list` */

insert  into `t_sale_list`(`id`,`amountPaid`,`amountPayable`,`remarks`,`saleDate`,`saleNumber`,`state`,`customerId`,`userId`) values (65,50,50,'123','2022-05-12 23:26:25','XS202205120001',5,30,1);

/*Table structure for table `t_sale_list_goods` */

DROP TABLE IF EXISTS `t_sale_list_goods`;

CREATE TABLE `t_sale_list_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) DEFAULT NULL,
  `goodsId` int(11) DEFAULT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` float NOT NULL,
  `total` float NOT NULL,
  `unit` varchar(10) DEFAULT NULL,
  `saleListId` int(11) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `returnNum` int(11) DEFAULT NULL,
  `isReturn` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK20ehd6ta9geyql4hxtdsnhbox` (`saleListId`),
  KEY `FKn9i5p1d8f0gek5x7q45cq8ibw` (`typeId`),
  KEY `goodsId` (`goodsId`),
  CONSTRAINT `FK20ehd6ta9geyql4hxtdsnhbox` FOREIGN KEY (`saleListId`) REFERENCES `t_sale_list` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_sale_list_goods_ibfk_1` FOREIGN KEY (`goodsId`) REFERENCES `t_goods` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

/*Data for the table `t_sale_list_goods` */

insert  into `t_sale_list_goods`(`id`,`code`,`goodsId`,`model`,`name`,`num`,`price`,`total`,`unit`,`saleListId`,`typeId`,`status`,`returnNum`,`isReturn`) values (96,'0034',37,'1.3kg','宝路Pedigree 肉类奶蔬菜幼犬粮 1.3kg',1,40,40,'包',65,36,1,0,0);

/*Table structure for table `t_salelist_payment_information` */

DROP TABLE IF EXISTS `t_salelist_payment_information`;

CREATE TABLE `t_salelist_payment_information` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saleNumber` varchar(100) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `payDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  CONSTRAINT `t_salelist_payment_information_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_salelist_payment_information` */

insert  into `t_salelist_payment_information`(`id`,`saleNumber`,`type`,`amount`,`customerId`,`payDate`) values (12,'XS202205120001',2,50,30,'2022-05-12 23:26:35');

/*Table structure for table `t_suggestion` */

DROP TABLE IF EXISTS `t_suggestion`;

CREATE TABLE `t_suggestion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) DEFAULT NULL,
  `customerId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `reply` varchar(1000) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerId` (`customerId`),
  KEY `userId` (`userId`),
  CONSTRAINT `t_suggestion_ibfk_1` FOREIGN KEY (`customerId`) REFERENCES `t_customer` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_suggestion_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_suggestion` */

/*Table structure for table `t_supplier` */

DROP TABLE IF EXISTS `t_supplier`;

CREATE TABLE `t_supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(300) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `number` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_supplier` */

insert  into `t_supplier`(`id`,`address`,`contact`,`name`,`number`,`remarks`) values (14,'福州新弯曲51号','张三','张三宠物狗养殖场','1366565188','张三宠物狗养殖场'),(15,'福州新弯曲14号','李四','李四宠物猫养殖场','13422325633','李四宠物猫养殖场'),(16,'福州新弯曲15号','王五','王五鸟类养殖场','13623654234','鸟类养殖场'),(17,'广西北流市民乐镇民北路100号','赵六','赵六兔子养殖场','13667832212','赵六兔子养殖场'),(18,'广西北流市民乐镇民北路2211号','小明','小明仓鼠养殖场','13667832034','小明仓鼠养殖场'),(19,'广西北流市民乐镇','小光','小光狗粮批发','13667822012','小光狗粮批发'),(20,'广西北流市民乐镇民北路11号','小花','小花宠物医疗用品批发','13667832044','小花宠物医疗用品批发');

/*Table structure for table `t_tackle` */

DROP TABLE IF EXISTS `t_tackle`;

CREATE TABLE `t_tackle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_tackle` */

insert  into `t_tackle`(`id`,`name`,`status`) values (3,'医院用品1',0),(4,'医院用品2',0);

/*Table structure for table `t_tackleoutlog` */

DROP TABLE IF EXISTS `t_tackleoutlog`;

CREATE TABLE `t_tackleoutlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `beginDate` datetime DEFAULT NULL,
  `endDate` datetime DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `tackleId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `tackleId` (`tackleId`),
  CONSTRAINT `t_tackleoutlog_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `t_tackleoutlog_ibfk_2` FOREIGN KEY (`tackleId`) REFERENCES `t_tackle` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_tackleoutlog` */

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(50) DEFAULT NULL,
  `remarks` varchar(1000) DEFAULT NULL,
  `trueName` varchar(50) DEFAULT NULL,
  `userName` varchar(50) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `imageName` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`password`,`remarks`,`trueName`,`userName`,`type`,`imageName`) values (1,'admin','管理员','乐道','admin',1,NULL),(2,'123','主管','杰克','jack',1,NULL),(3,'123','销售经理','玛丽','marry',1,NULL),(4,'123','仓库管理员','雪莉','sherry',1,NULL),(7,'333','主管','汤姆','tom',1,'20200127171852.jpg'),(8,'333','医生','张三','zhangsan',2,'20200127173702.jpg'),(9,'333','医生','大花','dahua',2,'20200127173709.jpg'),(10,'333','医生','李四','lisi',2,'20200127173724.jpg'),(11,'333','医生','二花','erhua',2,'20200127173731.jpg'),(12,'333','医生','三花','sanhua',2,'20200127173736.jpg'),(13,'333','医生','王五','wangwu',2,'20200127173742.jpg'),(14,'333','医生','赵六','zhaoliu',2,'20200127173856.jpg'),(15,'333','美容师','戴安娜','daianna',3,'20200204162744.jpg');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9c8iiy6ut0gnx491fqx4pxam` (`roleId`),
  KEY `FKq5un6x7ecoef5w1n39cop66kl` (`userId`),
  CONSTRAINT `FKa9c8iiy6ut0gnx491fqx4pxam` FOREIGN KEY (`roleId`) REFERENCES `t_role` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKq5un6x7ecoef5w1n39cop66kl` FOREIGN KEY (`userId`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`id`,`roleId`,`userId`) values (1,1,1),(19,2,2),(20,4,2),(21,5,2),(28,2,3),(29,4,3),(30,5,3),(31,7,3),(78,7,4),(109,10,8),(110,10,9),(111,10,10),(112,10,11),(113,10,12),(115,10,14),(116,11,15),(117,2,7),(118,7,7),(119,9,7),(120,10,13),(121,12,13);

/*Table structure for table `t_vaccine` */

DROP TABLE IF EXISTS `t_vaccine`;

CREATE TABLE `t_vaccine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `customerName` varchar(100) DEFAULT NULL,
  `petName` varchar(100) DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `t_vaccine` */

insert  into `t_vaccine`(`id`,`createDate`,`customerName`,`petName`,`content`) values (1,'2022-05-13 04:25:06','傅丽','小r','1eqweq'),(2,'2022-05-13 04:25:21','傅丽','小r','dadadasda');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
