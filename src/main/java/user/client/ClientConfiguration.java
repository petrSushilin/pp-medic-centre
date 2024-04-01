package user.client;

import org.jooq.DSLContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import user.client.handlers.GetAllClientsHandler;
import user.client.handlers.GetClientHandler;
import user.client.handlers.PostClientHandler;

@Configuration
public class ClientConfiguration {
    @Bean
    public ClientDAO userDAO(DSLContext context){
        return new ClientDAO(context);
    }

    @Bean
    public ClientService userService(ClientDAO clientDAO) {
        return new ClientService(clientDAO);
    }

    @Bean
    public GetAllClientsHandler getAllUsersHandler(ClientService clientService) {
        return new GetAllClientsHandler(clientService);
    }

    @Bean
    public GetClientHandler getUserHandler(ClientService clientService) {
        return new GetClientHandler(clientService);
    }

    @Bean
    public PostClientHandler postClientHandler(ClientService clientService) {
        return new PostClientHandler(clientService);
    }

    @Bean
    public ClientController clientController(GetAllClientsHandler getAllClientsHandler, GetClientHandler getClientHandler,
                                             PostClientHandler postClientHandler) {
        return new ClientController(getAllClientsHandler, getClientHandler, postClientHandler);
    }
}
