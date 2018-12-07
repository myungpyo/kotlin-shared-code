import Foundation


class MemoDataSourceImpl: MemoDataSource {
    
    static let MOCK_NETWORK_DELAY: UInt32 = 1 //sec
    static let MAX_MOCK_MEMO: Int32 = 100
    
    let calender = Calendar.current
    
    lazy var mockMemos: [MemoModel] = {
        (1..<MemoDataSourceImpl.MAX_MOCK_MEMO).map {
            let date = self.calender.date(byAdding: .day, value: (-1 * Int($0)), to: Date())
            let timeInterval = Int64(date?.timeIntervalSince1970 ?? 0)

            return MemoModel(id: $0, title: "Test Memo \($0)", content: "This is test memo \($0)", createdAt: timeInterval, lastModifiedAt: timeInterval)
        }
    } ()
    
    func getAllMemos() -> [MemoModel] {
        sleep(MemoDataSourceImpl.MOCK_NETWORK_DELAY)
        return self.mockMemos
    }
    
    func getMemo(id: Int32) -> MemoModel? {
        
        if (id <= 0 || id > MemoDataSourceImpl.MAX_MOCK_MEMO) {
            return nil
        }
        
        sleep(MemoDataSourceImpl.MOCK_NETWORK_DELAY)
        return self.mockMemos[Int(id) - 1]
    }
}
