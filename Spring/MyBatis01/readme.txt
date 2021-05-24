Mybatis的命名参数传递
    源码中的 names 是通过判断该方法是否有 param 注解，如果有，则获取注解对应的值，并将其封装到 Map 中，最后赋值给 names
    names 里的值为 0 -> id, 1 -> lastName
    是因为在为 Map 中存值时，是在一个循环中，Map 中的 key 为迭代时的索引，value 为注解对应的值。

    args 是一直在传递的Object数组，args[0] = 9, args[1] = "修改测试"
    最后在方法中通过一系列的判断，走到为 param 赋值，
    通过对 names 迭代为 param 赋值，param 的 key 为 entry.getValue(),即 id, value 为 args[entry.getKey()],即 9,
    然后通过对 names 判断是否存在 param1 ，如果不存在，则为 param 赋值 key = param1,value = args[entry.getKey()] = 9
    最后循环完，返回 param。
    param最后存储的值为    id -> 9
                          lastName -> "修改测试"
                          param1 -> 9
                          param2 -> "修改测试"