package com.fd.tryout.springbatch.batch;

import com.fd.tryout.springbatch.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author furkand
 * 10/26/2018 6:09 PM
 */
@Slf4j
public class PersonStreamWriter implements ItemStreamWriter<Person> {

    OutputStream outputStream;

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        try {
            File file = new File(System.getProperty("user.dir") + "/output.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            this.outputStream = new FileOutputStream(file);
        } catch (Exception e) {
            throw new ItemStreamException(e.getMessage(), e);
        }
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        // N/A
    }

    @Override
    public void close() throws ItemStreamException {
        if (this.outputStream != null) {
            try {
                this.outputStream.close();
            } catch (IOException e) {
                log.error("Cannot close stream");
            }
        }
    }

    @Override
    public void write(List<? extends Person> list) throws Exception {
        list.stream().forEach(x -> {
            try {
                this.outputStream.write(((Person) x).toString().getBytes());
            } catch (IOException e) {
                log.error("Cannot write person");
            }
        });
    }
}
