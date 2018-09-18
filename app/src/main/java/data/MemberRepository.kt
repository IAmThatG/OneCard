package data

class MemberRepository : IMemberRepository {
    override fun selectMembers(): MutableList<Member> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun selectMemberById(memberId: Long): Member? {
        var foundMember: Member? = null
        InMemoryData.members.forEach{
            if(it.id == memberId) {
                foundMember = it
            }
        }
        return foundMember
    }
}