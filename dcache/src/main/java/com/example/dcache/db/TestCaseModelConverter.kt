package com.example.dcache.db

import com.example.dcache.model.TestCaseModel
import dora.db.converter.BaseJsonConverter
import dora.db.converter.PropertyConverter

class TestCaseModelConverter : BaseJsonConverter<TestCaseModel>(),
    PropertyConverter<TestCaseModel, String> {
}