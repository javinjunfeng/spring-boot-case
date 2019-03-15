package top.javinjunfeng.springboot.jdbc.template;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class FooDao {
    private static final Logger log = LoggerFactory.getLogger(FooDao.class);
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public FooDao() {
    }

    public void insertData() {
        Arrays.asList("b", "c").forEach((bar) -> {
            this.jdbcTemplate.update("INSERT INTO FOO (BAR) VALUES (?)", new Object[]{bar});
        });
        HashMap<String, String> row = new HashMap();
        row.put("BAR", "d");
        Number id = this.simpleJdbcInsert.executeAndReturnKey(row);
        log.info("ID of d: {}", id.longValue());
    }

    public void listData() {
        log.info("Count: {}", this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM FOO", Long.class));
        List<String> list = this.jdbcTemplate.queryForList("SELECT BAR FROM FOO", String.class);
        list.forEach((s) -> {
            log.info("Bar: {}", s);
        });
        List<Foo> fooList = this.jdbcTemplate.query("SELECT * FROM FOO", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Foo.builder().id(rs.getLong(1)).bar(rs.getString(2)).build();
            }
        });
        fooList.forEach((f) -> {
            log.info("Foo: {}", f);
        });
    }
}