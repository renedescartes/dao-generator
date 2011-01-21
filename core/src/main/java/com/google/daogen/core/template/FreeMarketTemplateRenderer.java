package com.google.daogen.core.template;

import com.google.daogen.core.CodeGenerationException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarketTemplateRenderer implements TemplateRenderer {
    private Configuration configuration;

    public FreeMarketTemplateRenderer(String directoryName) {
        configuration = new Configuration();
        configuration.setClassForTemplateLoading(this.getClass(), "/com/google/daogen/core/template/files");
        configuration.setObjectWrapper(new DefaultObjectWrapper());
    }
    
    public void renderTemplate(Writer writer, String templateName, Object objectDetail) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("entity", objectDetail);
        Template template;
        try {
            template = configuration.getTemplate(templateName);
        } catch (IOException e) {
            throw new CodeGenerationException("Could not locate template [" + templateName + "]", e);
        }
        try {
            template.process(model, writer);
        } catch (TemplateException e) {
            throw new CodeGenerationException("Could not process template [" + templateName + "]", e);
        } catch (IOException e) {
            throw new CodeGenerationException("Problem writing the output to writer" , e);
        }
    }
}
