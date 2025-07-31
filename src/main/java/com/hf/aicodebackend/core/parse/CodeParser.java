package com.hf.aicodebackend.core.parse;

import com.hf.aicodebackend.ai.model.HtmlCodeResult;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 代码解析器策略接口
 * 
 * @author yupi
 */
public interface CodeParser<T> {

    /**
     * 解析代码内容
     * 
     * @param codeContent 原始代码内容
     * @return 解析后的结果对象
     */
    T parseCode(String codeContent);

    /**
     * HTML 单文件代码解析器
     *
     * @author yupi
     */
    public class HtmlCodeParser implements CodeParser<HtmlCodeResult> {

        private static final Pattern HTML_CODE_PATTERN = Pattern.compile("```html\\s*\\n([\\s\\S]*?)```", Pattern.CASE_INSENSITIVE);

        @Override
        public HtmlCodeResult parseCode(String codeContent) {
            HtmlCodeResult result = new HtmlCodeResult();
            // 提取 HTML 代码
            String htmlCode = extractHtmlCode(codeContent);
            if (htmlCode != null && !htmlCode.trim().isEmpty()) {
                result.setHtmlCode(htmlCode.trim());
            } else {
                // 如果没有找到代码块，将整个内容作为HTML
                result.setHtmlCode(codeContent.trim());
            }
            return result;
        }

        /**
         * 提取HTML代码内容
         *
         * @param content 原始内容
         * @return HTML代码
         */
        private String extractHtmlCode(String content) {
            Matcher matcher = HTML_CODE_PATTERN.matcher(content);
            if (matcher.find()) {
                return matcher.group(1);
            }
            return null;
        }
    }

}
