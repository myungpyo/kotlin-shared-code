
protocol MemoDataSource {
    func getAllMemos() -> [MemoModel]
    func getMemo(id: Int32) -> MemoModel?
}
