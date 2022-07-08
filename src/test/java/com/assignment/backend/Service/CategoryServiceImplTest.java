package com.assignment.backend.Service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.assignment.backend.data.entities.Category;
import com.assignment.backend.data.repositories.CategoryRepository;
import com.assignment.backend.dto.request.CategoryCreateDto;
import com.assignment.backend.dto.response.CategoryResponseDto;
import com.assignment.backend.services.impl.CategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryServiceImpl;

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;
    private Category expectedCategory;
    private Category initializeCategory;

    @BeforeEach
    public void beforeEach() {
        modelMapper = new ModelMapper();
        categoryRepository = mock(CategoryRepository.class);
        categoryServiceImpl = new CategoryServiceImpl(categoryRepository, modelMapper);
        expectedCategory = mock(Category.class);
        initializeCategory = mock(Category.class);
    }

    @Test
    public void whenMapGameWithExactMatch_thenConvertsToDTO() {
        // when similar source object is provided
        Category cate = new Category();
        cate.setName("test");
        cate.setDescription("test");
        CategoryResponseDto dto = new CategoryResponseDto();
        dto.setName("test");
        dto.setDescription("test");

        // then it maps by default
        assertEquals(cate.getName(), dto.getName());
        assertEquals(cate.getDescription(), dto.getDescription());
    }

    @Test
    public void createNewCategory_ShouldReturnCategory_WhenDataValid() {
        CategoryCreateDto dto = new CategoryCreateDto();
        dto.setCateName("Test 1");
        dto.setCateDescription("Test 1");

        CategoryResponseDto result = categoryServiceImpl.createNewCategory(dto);

        verify(initializeCategory).setName(dto.getCateName());
        verify(initializeCategory).setDescription(dto.getCateDescription());

        assertThat(result.getName(), is(dto.getCateName()));
        assertThat(result.getDescription(), is(dto.getCateDescription()));
    }

    @Test
    public void getCategory_ShouldReturnCategoryResponse_WhenDataInvalid() {
        int id = 1;
        when(this.categoryRepository.findById(id)).thenReturn(Optional.of(initializeCategory));
        assertThat(initializeCategory, isNull());
    }
}
