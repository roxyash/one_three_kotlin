fun findChar(str:String,separator: Char,f1:(Int,Int)->Boolean={st1:Int,st2:Int -> st1 > st2}, f2:(Int) -> Boolean = {str:Int -> str % 2 == 0}):Char?
{
    var res:Char? = null
    var char:Char? = null
    var oldCount = 0
    var newCount = 0
    for(i in 0..str.length)
    {
        if (i != str.length && str[i] != separator) {
            newCount++
            if (i == str.length - 2 && newCount > 1 || i + 2 < str.length && str[i+2] == separator)
                char = str[i]
        }
        else if (newCount != 0)
        {
            if (f2(newCount) && f1(newCount,oldCount)) {
                res = char
                oldCount = newCount
            }
            newCount = 0
            char = null
        }
    }

    return res
}