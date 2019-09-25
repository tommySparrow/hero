package com.house.hero.java.javacapacity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * key-value对象
 * @author User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entry {
    Object key;
    Object value;
}
