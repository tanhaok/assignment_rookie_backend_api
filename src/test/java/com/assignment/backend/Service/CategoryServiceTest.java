package com.assignment.backend.Service;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.assignment.backend.data.entities.Category;
import com.assignment.backend.data.repositories.CategoryRepository;
import com.assignment.backend.dto.request.CategoryCreateDto;
import com.assignment.backend.dto.response.CategoryResponseDto;
import com.assignment.backend.services.impl.CategoryServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private ModelMapper mapper;

    @Mock
    private Category category;

    @Mock
    private CategoryCreateDto createDto;

    @BeforeEach
    public void setUp() {
        Category.builder().id(1).name("test").description("description").createDate(new Date()).updateDate(new Date())
                .status("Active").product(null).build();

    }

    @Test
    public void createNewCategory_ShouldReturnDto_WhenDataValid() {
        when(categoryRepository.findByName("test")).thenReturn(Optional.empty());

        when(categoryRepository.save(category)).thenReturn(category);

        CategoryCreateDto dto = new CategoryCreateDto();
        dto.setCateName("test");
        dto.setCateDescription("description");

        CategoryResponseDto res = new CategoryResponseDto();

        when(mapper.map(dto, Category.class)).thenReturn(category);
        when(mapper.map(category, CategoryResponseDto.class)).thenReturn(res);

        CategoryResponseDto result = categoryService.createNewCategory(dto);

        assertThat(result.getName(), is(category.getName()));
    }
}
