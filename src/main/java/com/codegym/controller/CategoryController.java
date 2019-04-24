package com.codegym.controller;

import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
}
