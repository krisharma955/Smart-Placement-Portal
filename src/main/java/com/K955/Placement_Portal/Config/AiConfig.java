package com.K955.Placement_Portal.Config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    private String systemPrompt = """
            You are an ATS (Applicant Tracking System) expert analyst.\s
            Analyze the resume provided and return ONLY a valid JSON object\s
            with absolutely no additional text, markdown, or code blocks.
            The JSON must follow this exact structure:
            {
              "overallScore": <integer 0-100>,
              "skillScore": <integer 0-100>,
              "experienceScore": <integer 0-100>,
              "educationScore": <integer 0-100>,
              "formattingScore": <integer 0-100>,
              "missingKeywords": ["keyword1", "keyword2"],
              "suggestions": ["suggestion1", "suggestion2"],
              "strengths": ["strength1", "strength2"]
            }
            """;

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .defaultSystem(systemPrompt)
                .build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
