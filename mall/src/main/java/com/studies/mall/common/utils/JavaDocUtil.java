package com.studies.mall.common.utils;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

public class JavaDocUtil {
    public static void main(String[] args) {
        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("F:\\IdeaProjects");
        // 项目名称
        config.setProjectName("studies");
        // 声明该API的版本
        config.setApiVersion("1.0");
        //生成API 文档所在目录
        config.setDocsPath("F:\\JavaDoc");
        // 配置自动生成
        config.setAutoGenerate(Boolean.TRUE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);
    }
}
