package com.google.daogen.core.template;

import java.io.Writer;

public interface TemplateRenderer {

    public void renderTemplate(Writer writer, String templateName, Object objectDetail);
}
