package mvc.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import mvc.command.NullHandler;

public class ControllerUsingURI extends HttpServlet {

    // <커맨드, 핸들러인스턴스> 매핑 정보 저장
    private Map<String, CommandHandler> commandHandlerMap = 
    		new HashMap<>();

    public void init() throws ServletException {
        String configFile = getInitParameter("configFile");//servlet이 가지고있는 매소드, web.xml 안에 있음. web.xml의 config의 내용을 불러옴, getInitParameter 불러온다는 뜻. 즉 web.xml의 configfile을 불러옴
        Properties prop = new Properties();//properties의 값을 가지고 있는 명령어.
        String configFilePath = getServletContext().getRealPath(configFile);//getRealPath == 실제경로
        try (FileReader fis = new FileReader(configFilePath)) {
            prop.load(fis);//commandHandlerURI.properties를 불러옴. 그 안의 내용이 속성이 외어서 가져옴.
        } catch (IOException e) {
            throw new ServletException(e);
        }
        Iterator keyIter = prop.keySet().iterator();//Iterrator는 commandHandlerURI안의 경로들을 순서대로 방문함.
        while (keyIter.hasNext()) {//가져온 경로들을 반복하여 나타냄.
            String command = (String) keyIter.next();//
            String handlerClassName = prop.getProperty(command);
            try {
                Class<?> handlerClass = Class.forName(handlerClassName);//commandHandlerURI의  뒤 경로를 class로 변경시키기 위해 Class<?>를 사용 handlerClassName은 properties안에 있는 member.command.JoinHandler등등..
                CommandHandler handlerInstance = //write articlehandler에서 설명 계속write.do
                        (CommandHandler) handlerClass.newInstance();
                commandHandlerMap.put(command, handlerInstance);
            } catch (ClassNotFoundException | InstantiationException 
            		| IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
		String command = request.getRequestURI();//요청 이름 commandHHandlerURI.properties의 article/write.do 를 요청함. 
		if (command.indexOf(request.getContextPath()) == 0) {
			command = command.substring(request.getContextPath().length());
		}
        CommandHandler handler = commandHandlerMap.get(command);
        if (handler == null) {
            handler = new NullHandler();
        }
        String viewPage = null;
        try {
            viewPage = handler.process(request, response);
        } catch (Throwable e) {
            throw new ServletException(e);
        }
        if (viewPage != null) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
	        dispatcher.forward(request, response);
        }
    }
}
