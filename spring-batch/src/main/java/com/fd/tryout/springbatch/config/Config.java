package com.fd.tryout.springbatch.config;

import com.fd.tryout.springbatch.batch.PersonProcessor;
import com.fd.tryout.springbatch.batch.PersonStreamWriter;
import com.fd.tryout.springbatch.batch.ToUpperCaseJobExecutionListener;
import com.fd.tryout.springbatch.model.Person;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * @author furkand
 * 10/26/2018 5:57 PM
 */
@Configuration
@EnableBatchProcessing
public class Config {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private Step toUpperCaseConverter;

    @Bean
    public FlatFileItemReader<Person> reader() {
        return new FlatFileItemReaderBuilder<Person>()
                .name("personReader")
                .resource(new ClassPathResource("data.csv"))
                .delimited()
                .names(new String[]{"name", "surname"})
                .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
                    setTargetType(Person.class);
                }})
                .build();
    }

    @Bean
    public PersonProcessor processor() {
        return new PersonProcessor();
    }

    @Bean
    public PersonStreamWriter writer() {
        return new PersonStreamWriter();
    }

    @Bean
    public ToUpperCaseJobExecutionListener listener() {
        return new ToUpperCaseJobExecutionListener();
    }

    @Bean("toUpperCaseJob")
    public Job convertToUpperCaseJob(ToUpperCaseJobExecutionListener listener) {
        return this.jobBuilderFactory.get("toUpperCaseJob")
                .listener(listener)
                .flow(this.toUpperCaseConverter)
                .end()
                .build();
    }

    @Bean
    public Step toUpperCaseConverter() {
        return this.stepBuilderFactory.get("toUpperCase")
                .<Person, Person>chunk(10)
                .reader(this.reader())
                .processor(this.processor())
                .writer(this.writer())
                .build();
    }

}
