package com.ajs.apppush.component;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphProvider implements GraphUseCase{
	
	private final UserDataFetcher userDataFetcher;
	
	@Value("classpath:flowerLike.graphql")
	Resource resource;
	
	private GraphQL graphQL;
	
	public GraphProvider(UserDataFetcher userDataFetcher) {
		this.userDataFetcher = userDataFetcher;
	}
	
	@Override
	public ExecutionResult execute(String query) {
		return graphQL.execute(query);
	}

	@PostConstruct
    private void loadSchema() throws IOException {

        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("user", userDataFetcher))
                .build();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }
	
}
