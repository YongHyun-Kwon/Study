package xml0426;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLParsing3 {
	public static String[] rssTitle = { "속보", "정치", "경제", "사회", "국제", "문화", "연예", "스포츠", "풀영상", "뉴스랭킹", "뉴스룸", "아침&amp;", "썰전 라이브",
			"정치부회의" };

	public static String[] rssURL = { "https://fs.jtbc.joins.com/RSS/newsflash.xml", "https://fs.jtbc.joins.com/RSS/politics.xml",
			"https://fs.jtbc.joins.com/RSS/economy.xml", "https://fs.jtbc.joins.com/RSS/society.xml",
			"https://fs.jtbc.joins.com/RSS/international.xml", "https://fs.jtbc.joins.com/RSS/culture.xml",
			"https://fs.jtbc.joins.com/RSS/entertainment.xml", "https://fs.jtbc.joins.com/RSS/sports.xml",
			"https://fs.jtbc.joins.com/RSS/fullvideo.xml", "https://fs.jtbc.joins.com/RSS/newsrank.xml",
			"https://fs.jtbc.joins.com/RSS/newsroom.xml", "https://fs.jtbc.joins.com/RSS/morningand.xml",
			"https://fs.jtbc.joins.com/RSS/ssulzunlive.xml", "https://fs.jtbc.joins.com/RSS/politicaldesk.xml" };

	public XMLParsing3() throws MalformedURLException, JDOMException, IOException {
		
		Document doc = new SAXBuilder().build(new URL(rssURL[0]));
		
		Element rssNode = doc.getRootElement();
		System.out.println(rssNode);
		
		Element channelNode = rssNode.getChild("channel");
		System.out.println(channelNode);
		
		Element pubNode = channelNode.getChild("pubDate");
		String pubDate = pubNode.getText();
		System.out.println(pubDate);
		
		Element titleNode = channelNode.getChild("title");
		String title = titleNode.getText();
		System.out.println(title);
		
		List<Element> listItemNodes = channelNode.getChildren("item");
		
		Element titleNodes = null;
		Element pubNodes = null;
		
		for( Element itemNode : listItemNodes ) {
			titleNodes = itemNode.getChild("title");
			pubNodes = itemNode.getChild("pubDate");
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			new XMLParsing3();
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
