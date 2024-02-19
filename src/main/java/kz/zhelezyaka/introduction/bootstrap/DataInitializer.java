package kz.zhelezyaka.introduction.bootstrap;

import kz.zhelezyaka.introduction.domain.Employee;
import kz.zhelezyaka.introduction.domain.Product;
import kz.zhelezyaka.introduction.repositories.EmployeeRepository;
import kz.zhelezyaka.introduction.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final EmployeeRepository employeeRepository;


    @Override
    public void run(String... args) throws Exception {
        Employee vladimir = new Employee(1L, "Vladimir", "Sadovaya 23");
        Employee svetlana = new Employee(2L, "Svetlana", "Kotanova 34");
        Product beer = new Product(1L, "Beer", null);
        Product wine = new Product(2L, "Wine", null);

        Employee vladSave = employeeRepository.save(vladimir);
        Employee svetlanaSave = employeeRepository.save(svetlana);
        Product beerSave = productRepository.save(beer);
        Product wineSave = productRepository.save(wine);

        employeeRepository.findAll().forEach(emp -> {
            out.println("Employee id: " + emp.getId());
            out.println("Employee address: " + emp.getAddress());
        });
        productRepository.findAll().forEach(prod -> {
            out.println("Product id: " + prod.getId());
            out.println("Product name: " + prod.getName());
        });
    }
}
