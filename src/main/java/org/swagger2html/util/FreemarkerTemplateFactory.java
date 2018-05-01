package org.swagger2html.util;

import freemarker.template.*;

import java.io.*;

/**
 * @author chenjianjx@gmail.com
 */
public class FreemarkerTemplateFactory {

    private static FreemarkerTemplateFactory instance;

    private FreemarkerTemplateFactory() {

    }

    public static FreemarkerTemplateFactory getInstance() {

        if (null == instance) {
            instance = new FreemarkerTemplateFactory();
        }
        return instance;
    }

    public Template getClasspathTemplate(String ftlClasspath) {

        Configuration configuration = new Configuration();
        configuration.setLocalizedLookup(false);
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setClassForTemplateLoading(
            FreemarkerTemplateFactory.class, "/");
        try {
            return configuration.getTemplate(ftlClasspath);
        } catch (IOException e) {
            throw new IllegalStateException(ftlClasspath, e);
        }
    }
}
