package springBootAnnotation.autowired;

public interface DemoService{
  public void doService();
}
@Service("one") // <-- bean name is "one"
public class DemoServiceOneImpl implements DemoService {
    @Override
    public void doService() {
        System.out.println("This is one...");
    }
}

@Service("two") // <-- bean name is "two"
public class DemoServiceTwoImpl implements DemoService {
    @Override
    public void doService() {
        System.out.println("This is two...");
    }
}

@RestController
public class DemoController {

    @Qualifier("one") // <--  Tell the Spring to inject "one" Bean， that is DemoServiceOneImpl
    @Autowired
    private DemoService demoService;

    @GetMapping("/")
    public void demo() {
        demoService.doService(); // DemoServiceOneImpl.doService()
    }

}