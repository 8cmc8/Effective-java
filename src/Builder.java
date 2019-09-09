import java.text.RuleBasedCollator;

//类的构造器或者静态工厂中具有多个参数时适合使用
//保证对象创建的安全性
//只有在执行build方法时，实例对象才会被创建。保证了"创建即完整"的功能。
//中间的builder对象虽然被创建了但是没有被使用
public class Builder {
    public static void main(String[] args) {
        Person person = new Person.Builder("男", 9).build();
        System.out.println(person);
    }
}
class Person {
    private final String sex;
    private final int age;
    private final int height;
    private final int weight;

    public static class Builder {
        private final String sex;
        private final int age;

        private int height;
        private int weight;

        public Builder(String sex, int age) throws RuntimeException {
            if ("男".equals(sex) || "女".equals(sex)) {
                this.sex = sex;
            } else {
                throw new RuntimeException("sex wrong!");
            }

            if (age > 0) {
                this.age = age;
            } else {
                throw new RuntimeException("age must greater than 0");
            }
        }

        public Builder height(int height) {
            if (height > 0) {
                this.height = height;
            } else {
                throw new RuntimeException("height must greater than 0");
            }
            return this;
        }

        public Builder weight(int weight) {
            if (weight > 0) {
                this.weight = weight;
            } else {
                throw new RuntimeException("weight must greater than 0");
            }
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public Person(Builder builder) {
        sex = builder.sex;
        age = builder.age;
        height = builder.height;
        weight = builder.weight;
    }

    @Override
    public String toString() {
        return "sex=" + sex + "\n" + "age=" + age + "\n" + "height=" + height + "\n" + "weight" + weight;
    }
}


