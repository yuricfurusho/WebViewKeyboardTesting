package com.yuricfurusho.webviewkeyboardtesting.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import com.yuricfurusho.webviewkeyboardtesting.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel

//        webViewInput.addJavascriptInterface(this, "Android")
        val webSettings = webViewInput.getSettings()
        webSettings.setJavaScriptEnabled(true)

        webViewInput.setWebViewClient(object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {

                return true
            }

            override fun onPageFinished(view: WebView, url: String) {

//                cellManager.getWebViewCallBack().onSuccess(null)
            }

            override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
                super.onReceivedError(view, request, error)
//                cellManager.getWebViewCallBack().onFailure(null)
            }

        })

        val webChromeClient = object : WebChromeClient() {
            override fun onCloseWindow(window: WebView) {
                super.onCloseWindow(window)
            }
        }
        webViewInput.setWebChromeClient(webChromeClient)

        val mimeType = "text/html; charset=utf-8"
        val encoding = "UTF-8"

        val html = "<style> img {max-width: 100%; height: auto;}</style><blockquote>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zafi</strong><span style=\"font-size: 12pt;\">: Hello, Zarif. What&rsquo;s up?</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zarif</strong><span style=\"font-size: 12pt;\">: Not much What about you?</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zafi</strong><span style=\"font-size: 12pt;\">: I am OK. By the way, have you heard about the recent transparency report about India?</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zarif</strong><span style=\"font-size: 12pt;\">: Yes, I have. Can you believe that India is the third in corruption among the countries of the world?</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zafi</strong><span style=\"font-size: 12pt;\">: Yeah, that&rsquo;s too bad. It&rsquo;s hard to be patriotic with news like this...</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zarif</strong><span style=\"font-size: 12pt;\">: I know I should love my country, but what can I do now?</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zafi</strong><span style=\"font-size: 12pt;\">: I hear you. It seems that almost everyone in the country is corrupt, from clerks to ministers.</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zarif</strong><span style=\"font-size: 12pt;\">: Exactly! They only act on their own interests.</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zafi</strong><span style=\"font-size: 12pt;\">: Our government should do its best to eradicate corruption and I think everyone should do their part.</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zarif</strong><span style=\"font-size: 12pt;\">: I agree with you. Otherwise, there will be no hope for the nation.</span></p>\n" +
                "<p style=\"text-align: justify;\"><strong style=\"font-size: 12pt;\">Zafi</strong><span style=\"font-size: 12pt;\">: Absolutely! The earlier the better.</span></p>\n" +
                "<p style=\"text-align: left;\">&nbsp;</p>\n" +
                "<p style=\"text-align: left;\"><span style=\"font-size: 10pt;\">Source: TUTORIAL WATCH. <em>Conversation Between Two Friends on corruption</em>. Available at: &lt;http://www.tutorialwatch.in/conversation-between-two-friends/&gt;. Accessed on: 13 September 2016.</span></p>\n" +
                "<p style=\"text-align: left;\">&nbsp;</p>\n" +
                "</blockquote>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">Read the sentences based on the dialogue and reply agreeing with them. Check the example.</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">A. I know about the recent transparency report about India.</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\"><strong>So do I. / I do, too.</strong></span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">B. I can&rsquo;t change my country alone.</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\"><input value=\"dsadsadasdas\" id=\"lacuna_input_1\" oninput=\"javascript: Android.oninputletters(0, this.value)\" onchange=\"javascript: Android.oninputchanged(0, this.value)\" class=\"mceInput\" style=\"font-family:verdana;font-size:12px;border:solid 2px #7b20a2\" type=\"text\" name=\"lacuna_input_1\" /></span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">C. I should&nbsp;do my best to eradicate corruption.</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\"><input value=\"dsadasdasdas\" id=\"lacuna_input_2\" oninput=\"javascript: Android.oninputletters(1, this.value)\" onchange=\"javascript: Android.oninputchanged(1, this.value)\" class=\"mceInput\" style=\"font-family:verdana;font-size:12px;border:solid 2px #7b20a2\" type=\"text\" name=\"lacuna_input_2\" /></span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">D. I am not corrupt.</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\"><input value=\"dsadasdadas\" id=\"lacuna_input_3\" oninput=\"javascript: Android.oninputletters(2, this.value)\" onchange=\"javascript: Android.oninputchanged(2, this.value)\" class=\"mceInput\" style=\"font-family:verdana;font-size:12px;border:solid 2px #7b20a2\" type=\"text\" name=\"lacuna_input_3\" /></span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">&nbsp;</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\">E. I think the main cause of corruption is corrupted politics.</span></p>\n" +
                "<p style=\"text-align: justify;\"><span style=\"font-size: 12pt;\"><input value=\"dsadsadasdas\" id=\"lacuna_input_4\" oninput=\"javascript: Android.oninputletters(3, this.value)\" onchange=\"javascript: Android.oninputchanged(3, this.value)\" class=\"mceInput\" style=\"font-family:verdana;font-size:12px;border:solid 2px #7b20a2\" type=\"text\" name=\"lacuna_input_4\" /></span></p>"
        val start = "<html><head><meta http-equiv='Content-Type' content='text/html' charset='UTF-8' /></head><body>"
        val end = "</body></html>"

        webViewInput.loadData(start + html + end, mimeType, encoding)
    }

}
