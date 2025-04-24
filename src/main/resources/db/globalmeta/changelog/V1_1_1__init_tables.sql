
INSERT INTO `conditionaltype` (`name`, `hidden_flag`, `access_level`, `function_component`, `attribute_component`, `property_component`, `variable_component`, `other_component`, `component`, `description`, `additional_field`)
VALUES
    ('conditional(advancedcalculation:rowmode1)', 0, 'bill aggregator', 'billAggregatorFunction,billingCycleFunction', 'simpleAttribute,aggregationModelAttribute', 'property', 'aggregationModelVariable,billAggregatorInfoVariable,billAggregatorUsageModelVariable,billingCycleInfoVariable,billingCycleUsageModelVariable', NULL, NULL, 'applicable to AdvancedCalculation:RowMode rule model only since it can not access billingCycleAdvancedCalculationSpecialFunction', NULL);

