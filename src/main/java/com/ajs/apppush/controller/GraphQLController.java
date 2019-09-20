package com.ajs.apppush.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ajs.apppush.service.ContentsService;
import com.ajs.apppush.service.DonationService;
import com.ajs.apppush.service.EmployeeLikeService;
import com.ajs.apppush.service.EmployeeService;
import com.ajs.apppush.service.EmployeeStarService;
import com.ajs.apppush.service.EnterpriseAddressService;
import com.ajs.apppush.service.EnterpriseLikeService;
import com.ajs.apppush.service.EnterpriseService;
import com.ajs.apppush.service.EnterpriseStarService;
import com.ajs.apppush.service.OrderService;
import com.ajs.apppush.service.PhotoService;
import com.ajs.apppush.service.PushNotificationService;
import com.ajs.apppush.service.UserService;
import com.ajs.apppush.service.WorkingHistoryService;

import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import io.leangen.graphql.GraphQLSchemaGenerator;

@RestController
public class GraphQLController {
    private final GraphQL graphQL;

    public GraphQLController(	UserService userService,
    							EmployeeService employeeService,
    							EnterpriseService enterpriseService,
    							WorkingHistoryService workingHistoryService,
    							ContentsService contentsService,
    							DonationService donationService,
    							OrderService orderService,
    							PhotoService photoService,
    							PushNotificationService pushNotificationService,
    							EmployeeLikeService employeeLikeService,
    							EmployeeStarService employeeStarService,
    							EnterpriseAddressService enterpriseAddressService,
    							EnterpriseLikeService enterpriseLikeService,
    							EnterpriseStarService enterpriseStarService) {
        GraphQLSchema schema = new GraphQLSchemaGenerator()
        		.withBasePackages("com.ajs.apppush")
                .withOperationsFromSingletons(	userService, employeeService, enterpriseService, workingHistoryService, contentsService,
                								donationService, orderService, photoService, pushNotificationService, employeeLikeService,
                								employeeStarService, enterpriseAddressService, enterpriseLikeService, enterpriseStarService)
                .generate();

        graphQL = GraphQL.newGraphQL(schema).build();
    }

    
    @SuppressWarnings("unchecked")
	@PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Map<String, Object> graphql(@RequestBody Map<String, Object> request, HttpServletRequest raw) {
    	
    	System.out.println("-------------------------------------------------------------------------------------------------");
    	System.out.println(request.get("query"));
    	System.out.println(request.get("operationName"));
    	System.out.println("-------------------------------------------------------------------------------------------------");
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query").toString())
                .operationName(request.get("operationName") != null ? request.get("operationName").toString() : null)
                .variables((Map<String, Object>) request.get("variables"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }
    
}
