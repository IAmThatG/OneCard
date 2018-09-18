package core.services

import core.IMemberService
import data.IMemberRepository
import data.Member

class MemberService(private val mMemberRepo: IMemberRepository) : IMemberService {
    override fun getMembers(): MutableList<Member> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getMemberById(memberId: Long): Member? = mMemberRepo.selectMemberById(memberId)
}