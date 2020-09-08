package com.aye.service.email.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@Component
public class EmailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;



    @Value("${mail.fromMail.addr}")
    private String from;

//    private String  from ="240291083@qq.com";
    /**
     * 发送文本邮件
     * @param to
     * @param subject
     * @param content
     */

    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            logger.info("简单邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送简单邮件时发生异常！", e);
        }

    }

    /**
     * 发送html邮件
     * @param to
     * @param subject
     * @param content
     */

    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            logger.info("html邮件发送成功");
        } catch (MessagingException e) {
            logger.error("发送html邮件时发生异常！", e);
        }
    }


//    /**
//     * 发送带附件的邮件
//     * @param to
//     * @param subject
//     * @param content
//     * @param filePath
//     */
//    public void sendAttachmentsMail(String to, String subject, String content, String filePath){
//        MimeMessage message = mailSender.createMimeMessage();
//
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message, true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(subject);
//            helper.setText(content, true);
//
//            FileSystemResource file = new FileSystemResource(new File(filePath));
//            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
//            helper.addAttachment(fileName, file);
//            //helper.addAttachment("test"+fileName, file);
//
//            mailSender.send(message);
//            logger.info("带附件的邮件已经发送。");
//        } catch (MessagingException e) {
//            logger.error("发送带附件的邮件时发生异常！", e);
//        }
//    }

    /**
     * 发送带附件的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     */
    public void sendAttachmentMail(String to, String subject, String content, String... fileArr)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);

        // 添加附件
        for (String filePath : fileArr) {
            FileSystemResource fileResource = new FileSystemResource(new File(filePath));
            if (fileResource.exists()) {
                String filename = fileResource.getFilename();
                messageHelper.addAttachment(filename, fileResource);
            }
        }
        mailSender.send(mimeMessage);
        logger.info("【附件邮件】成功发送！to={}", to);
    }


    /**
     * 发送正文中有静态资源（图片）的邮件
     * @param to
     * @param subject
     * @param content
     * @param rscPath
     * @param rscId
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            logger.info("嵌入静态资源的邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送嵌入静态资源的邮件时发生异常！", e);
        }
    }


    /**
     * 发送带图片的邮件
     *
     * @param to
     * @param subject
     * @param content
     * @param imgMap
     */
    public void sendImgMail(String to, String subject, String content, Map<String, String> imgMap)
            throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(content, true);
        // 添加图片
        for (Map.Entry<String, String> entry : imgMap.entrySet()) {
            FileSystemResource fileResource = new FileSystemResource(new File(entry.getValue()));
            if (fileResource.exists()) {
                String filename = fileResource.getFilename();
                messageHelper.addInline(entry.getKey(), fileResource);
            }
        }
        mailSender.send(mimeMessage);
        logger.info("【图片邮件】成功发送！to={}", to);
    }

    /**
     * 发送模版邮件
     *
     * @param to
     * @param subject
     * @param paramMap
     * @param template
     * @throws MessagingException
     */
    public void sendTemplateMail(String to, String subject, Map<String, Object> paramMap, String template)
            throws MessagingException {
        Context context = new Context();
        // 设置变量的值
        context.setVariables(paramMap);
        String emailContent = templateEngine.process(template, context);
        sendHtmlMail(to, subject, emailContent);
        logger.info("【模版邮件】成功发送！paramsMap={}，template={}", paramMap, template);
    }
}
