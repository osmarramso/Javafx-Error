package org.openjfx;

import com.sun.webkit.dom.HTMLElementImpl;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class userPanelSceneController implements Initializable  {

    private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");

    @FXML public Pane processPaneField;
    @FXML public Text titleField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        WebView wv = new WebView();
        WebEngine we = wv.getEngine();
        we.load("https://www.milanuncios.com/");

        we.getLoadWorker().stateProperty().addListener((observable, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                Document doc = we.getDocument();

                Element inputField = null;
                try {
                    inputField =
                            (Element) XPathFactory.newInstance().newXPath().evaluate("//*[@class=\"ma-NavigationTopNav-mainActions-desktop\"]",
                                    doc, XPathConstants.NODE);
                } catch (XPathExpressionException e) {
                    e.printStackTrace();
                }
                if (inputField != null) {
                    HTMLElementImpl t = (HTMLElementImpl) inputField;
                    LOGGER.log(Level.INFO, "DENTRO "+t.getClass()+" "+t);

                    t.click();
                }
            }
        });

        processPaneField.getChildren().add(wv);

    }
}
