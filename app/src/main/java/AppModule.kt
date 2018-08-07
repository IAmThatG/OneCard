import com.example.hello.onecard.activities.MainActivity
import core.ICardService
import core.IMemberService
import core.services.CardService
import core.services.MemberService
import data.CardRepository
import data.ICardRepository
import data.IMemberRepository
import data.MemberRepository
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

object AppModule {
    fun loadModule(): Module = applicationContext {
        factory { CardService(get()) as ICardService }
        factory { MemberService(get()) as IMemberService }
        bean { CardRepository() as ICardRepository }
        bean { MemberRepository() as IMemberRepository }
    }
}