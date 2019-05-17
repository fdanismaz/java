## Compiling .proto files manually
If you want to use the protocol buffers compiler `protoc` manually, navigate to the folder of the source code and
execute the command below:

```
protoc -I=./main/resources --java_out=./main/java ./main/resources/adressbook.proto
```

## Protobuf Maven Plugin
With the `protoc-jar-maven-plugin` in the `pom.xml` the .proto files are searched under the `src/main/resources` folder
and compiled automatically during the `generate-sources` phase of maven build lifecycle


