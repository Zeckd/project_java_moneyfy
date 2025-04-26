package kg.megalab.expensetracker.models;

import jakarta.persistence.*;
import kg.megalab.expensetracker.enums.CategoryType;

@Entity
@Table (name = "catrgories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private CategoryType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CategoryType getType() {
        return type;
    }

    public void setType(CategoryType type) {
        this.type = type;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
