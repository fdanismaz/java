package com.fd.protobuf;

import com.fd.protobuf.proto.AddressBookProtos;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException {
        AddressBookProtos.Person furkan = AddressBookProtos.Person.newBuilder()
                .setId(123)
                .setName("furkan danismaz")
                .setEmail("...")
                .addPhones(
                        AddressBookProtos.Person.PhoneNumber.newBuilder()
                                .setNumber("555-1234")
                                .setType(AddressBookProtos.Person.PhoneType.MOBILE)
                        .build())
                .build();

        OutputStream os = new FileOutputStream(new File("./output"));
        furkan.writeTo(os);

        InputStream is = new FileInputStream(new File("./output"));
        AddressBookProtos.Person parsedPerson = AddressBookProtos.Person.parseFrom(is);

        System.out.println(parsedPerson);
    }
}
