@Entity
public class Practice{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int quantity;

    private int price;
    private int price2;

    
}