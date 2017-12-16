package control.service;


import control.repository.Repository;

public class Service {
    private Repository repository = new Repository();

    public String getHelloFromService() {
        return "Hello from Service! ";
    }

    public String getHelloFromRepository() {
        return repository.getHello();
    }
}
